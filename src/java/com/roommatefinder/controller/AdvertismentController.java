/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.AdvertismentDaoImpl;
import com.roommatefinder.daoImpl.UserDaoImpl;
import com.roommatefinder.model.Advertisment;
import com.roommatefinder.model.User;
import com.roommatefinder.validator.AdvertismentValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AshirwadTank
 */
@Controller
@RequestMapping("/advertisment")
public class AdvertismentController {

    
    @Autowired
    @Qualifier("advertismentValidator")
    private AdvertismentValidator validator;
    
    @Autowired
   ServletConfig servletConfig;

    @InitBinder("adModel")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model) {
        Advertisment adModel = new Advertisment();
        User userModel=new User();
        model.addAttribute("userModel", userModel);
        model.addAttribute("adModel", adModel);
        initModelList(model);
        return "pages/home/advertisment";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitForm(Model model, @ModelAttribute("adModel") @Valid Advertisment adModel, BindingResult result,HttpServletRequest request) {

        model.addAttribute("adModel", adModel);
        ModelAndView homeModel = new ModelAndView("pages/home/home");
        if (result.hasErrors()) {
           ModelAndView welcomeModel = new ModelAndView("pages/home/advertisment");
           System.out.println("Inside errors");
            return welcomeModel;
        } else {

            AdvertismentDaoImpl adi = new AdvertismentDaoImpl();
             User user = (User)request.getSession().getAttribute("users");
            
             adModel.setUserId((int)user.getId());
             
            int adId = adi.insert(adModel);
           
           
        }
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/view/{adId}", method = RequestMethod.GET)
    public ModelAndView advertismentDetail(Model model, @PathVariable("adId") int adId, @Valid Advertisment adModel, BindingResult result,HttpServletRequest request) throws IOException {

       
        
        AdvertismentDaoImpl adi = new AdvertismentDaoImpl();

        Advertisment adBean = adi.findByAdvertismentId(adId);
        UserDaoImpl userdao=new UserDaoImpl();
        User userBean = new User();
        
        ResultSet rs=userdao.getUserSettings(adBean.getUserId());
        try {
            while (rs.next()) {
                userBean.setName(rs.getString("FULLNAME"));
                userBean.setEmail(rs.getString("EMAIL"));
                userBean.setContact(rs.getString("CONTACT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("adModel", adBean);
        model.addAttribute("userBean", userBean);
        //model.addAttribute("imagePath",imageList);
        
        
        return new ModelAndView("pages/home/advertisementDetail");
    }
    
    @RequestMapping(value = "/delete/{adId}", method = RequestMethod.GET)
    public ModelAndView advertismentDelete(Model model, @PathVariable("adId") int adId, @Valid Advertisment adModel, BindingResult result,HttpServletRequest request) throws IOException {

       
        
        AdvertismentDaoImpl adi = new AdvertismentDaoImpl();

        boolean isDeleted = adi.deleteAdvertisement(adId);
       
        
        return new ModelAndView("redirect:/home");
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
