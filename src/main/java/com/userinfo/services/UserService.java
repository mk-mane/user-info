package com.userinfo.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.userinfo.entities.User;

@Service
public interface UserService {

	User saveUser(User user);

	Map<String, Boolean> checkValidators(User user);

	List<String> getValidationErrorMessages(Map<String, Boolean> map);

}
