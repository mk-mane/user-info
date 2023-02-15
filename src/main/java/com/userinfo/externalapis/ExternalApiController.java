package com.userinfo.externalapis;

import org.springframework.stereotype.Component;

@Component
public class ExternalApiController {

	public boolean emailValidator(String email) {
		String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		boolean isValidEmail;
		if (email.matches(regex)) {
			isValidEmail = true;
		} else {
			isValidEmail = false;
		}
		return isValidEmail;

	}

	public boolean phValidator(String ph) {
		String regex = "^[+]?[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]{6,16}$";
		boolean isValidPh;
		if (ph.matches(regex)) {
			isValidPh = true;
		} else {
			isValidPh = false;
		}
		return isValidPh;
	}

	public boolean ssnValidator(String ssn) {
		String regex = "^\\d{3}-?\\d{2}-?\\d{4}$";
		boolean isValidSsn;
		if (ssn.matches(regex)) {
			isValidSsn = true;
		} else {
			isValidSsn = false;
		}
		return isValidSsn;
	}
}
