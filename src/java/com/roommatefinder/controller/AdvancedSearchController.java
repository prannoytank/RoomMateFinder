package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.AdvertismentDaoImpl;
import com.roommatefinder.model.Advertisment;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DianaA
 */
@Controller
@RequestMapping("/search")
public class AdvancedSearchController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model) {

        Advertisment adModel1 = new Advertisment();
        model.addAttribute("adModel1", adModel1);
        initModelList(model);
        return "pages/home/advancedSearch";

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

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("adModel1") @Valid Advertisment adModel1, BindingResult result) {

        model.addAttribute("adModel1", adModel1);
        //initModelList(model);
        String returnVal = "successForm";
        if (result.hasErrors()) {
            returnVal = "pages/home/advancedSearch";
            //return "pages/home/advancedSearch";
        } else {
            try{
            AdvertismentDaoImpl adDAO = new AdvertismentDaoImpl();
            ResultSet rs = adDAO.searchAdvertisement(adModel1);
            while (rs.next()) {
                String id = rs.getString("ADTITLE");
                System.out.println("title is " + id);
            }
            }catch(SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

        return "pages/home/advancedSearch";
    }
 
 
 
}
