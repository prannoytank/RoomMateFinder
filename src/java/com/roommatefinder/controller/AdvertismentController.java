/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.model.Advertisment;
import com.roommatefinder.validator.AdvertismentValidator;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author AshirwadTank
 */
@Controller
@RequestMapping("/advertisment")
public class AdvertismentController {

    //@Autowired
    // @Qualifier("formValidator")
    // private Validator validator;
    
    @Autowired
    @Qualifier("advertismentValidator")
    private AdvertismentValidator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model) {
        Advertisment adModel = new Advertisment();

        model.addAttribute("adModel", adModel);

        return "pages/home/advertisment";
    }
    
    
 @RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model,@ModelAttribute("adModel") @Valid Advertisment adModel, BindingResult result) {
              
		model.addAttribute("adModel",adModel);
		String returnVal = "successForm";
		if(result.hasErrors()) {
			returnVal = "pages/home/advertisment";
		} else {
                  
                    
			model.addAttribute("adModel", adModel);
                        
		}		
		return returnVal;
	}   

}
