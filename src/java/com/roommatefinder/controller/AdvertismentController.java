/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.model.Advertisment;
import com.roommatefinder.validator.AdvertismentValidator;
import java.util.ArrayList;
import java.util.List;
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
        initModelList(model);
        return "pages/home/advertisment";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("adModel") @Valid Advertisment adModel, BindingResult result) {

        model.addAttribute("adModel", adModel);
        String returnVal = "successForm";
        if (result.hasErrors()) {
            returnVal = "pages/home/advertisment";
        } else {
            model.addAttribute("adModel", adModel);

        }
        return returnVal;
    }

    private void initModelList(Model model) {

        List<String> cities = new ArrayList<String>();
        cities.add("Toronto");
        cities.add("Montreal");
        cities.add("London");
        cities.add("Vancouver");
        cities.add("Calgary");
        cities.add("Winnipeg");
        model.addAttribute("cities", cities);

        List<String> gender = new ArrayList<String>();
        gender.add("Male");
        gender.add("Female");
        gender.add("Other");
        model.addAttribute("gender", gender);

        List<String> buildingType = new ArrayList<String>();
        buildingType.add("House");
        buildingType.add("Apartment");
        buildingType.add("Condo");
        model.addAttribute("buildingType", buildingType);

        List<Integer> noOfRooms = new ArrayList<Integer>();
        noOfRooms.add(1);
        noOfRooms.add(2);
        noOfRooms.add(3);
        noOfRooms.add(4);
        noOfRooms.add(5);
        model.addAttribute("noOfRooms", noOfRooms);

    }

}
