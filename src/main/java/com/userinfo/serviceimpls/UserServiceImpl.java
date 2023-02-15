package com.userinfo.serviceimpls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.entities.User;
import com.userinfo.externalapis.ExternalApiController;
import com.userinfo.repos.UserRepo;
import com.userinfo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	ExternalApiController externalApiController;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Map<String, Boolean> checkValidators(User user) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		// create a callable for each method
		Callable<Void> emailValidator = new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				map.put("email", externalApiController.emailValidator(user.getEmail()));
				return null;
			}
		};

		Callable<Void> phValidator = new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				map.put("phNumber", externalApiController.phValidator(user.getPhNumber()));
				return null;
			}
		};

		Callable<Void> ssnValidator = new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				map.put("ssn", externalApiController.ssnValidator(user.getSsn()));
				return null;
			}
		};

		// add to a list
		List<Callable<Void>> validators = new ArrayList<Callable<Void>>();
		validators.add(emailValidator);
		validators.add(phValidator);
		validators.add(ssnValidator);

		// create a pool executor with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		try {
			// start the threads and wait for them to finish
			executor.invokeAll(validators);
		} catch (InterruptedException ie) {
			// do something if you care about interruption;
		}
		return map;
	}

	
	@Override
	public List<String> getValidationErrorMessages(Map<String, Boolean> map) {
		List<String> errors = new ArrayList<String>();
		if (!map.get("email")) {
			errors.add("Please specify Valid Email");
		}
		if (!map.get("phNumber")) {
			errors.add("Please specify Valid ph Number");
		}
		if (!map.get("ssn")) {
			errors.add("Please specify Valid ssn");
		}
		return errors;
	}

}
