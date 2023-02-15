package com.userinfo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.entities.User;
import com.userinfo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserInfoController {

	@Autowired
	UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			Map<String, Boolean> map = userService.checkValidators(user);
			if (map.get("email") && map.get("phNumber") && map.get("ssn")) {
				User createdUser = userService.saveUser(user);
				return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<List<String>>(userService.getValidationErrorMessages(map),
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
