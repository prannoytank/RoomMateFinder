/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.validator;

import com.roommatefinder.model.Advertisment;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author AshirwadTank
 */
public class AdvertismentValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean supports(Class<?> paramClass) {
		return Advertisment.class.equals(paramClass);
	}

        @Override
	public void validate(Object obj, Errors errors) {
		Advertisment form = (Advertisment) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "adModel.country");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "province", "adModel.province");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "adModel.city");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetAddress", "adModel.streetAddress");
			
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalCode", "adModel.postalCode");
	}
}
