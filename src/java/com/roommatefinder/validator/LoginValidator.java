/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.validator;

import com.roommatefinder.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Crusty
 */
public class LoginValidator implements Validator{
    @Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.password");
             
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "login.email");
                
                  
		
	}
}
