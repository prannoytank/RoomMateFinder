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
 * @author DianaA
 */
public class SettingsValidator implements Validator{
    @Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "user.country");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetAddress", "user.streetAddress");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "province", "user.province");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "user.city");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalCode", "user.postalCode");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "user.contact");
                
                  
		
	}
}
