/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.validator;

/**
 *
 * @author Crusty
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.roommatefinder.model.User;
import org.springframework.validation.ValidationUtils;

public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.name");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passconf", "user.passwordConfDiff");
                   
                    if(!(user.getPassword().equals(user.getPassconf()))){
                            errors.rejectValue("passconf", "user.passwordConfDiff");
                    }
                
		
	}
	
}
