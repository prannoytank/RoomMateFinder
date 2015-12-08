/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.AdvertismentDaoImpl;
import com.roommatefinder.model.Advertisment;
import com.roommatefinder.model.User;
import com.roommatefinder.validator.AdvertismentValidator;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;

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
           System.out.println("Inside Success");
            //model.addAttribute("adId", adId);
        }
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/view/{adId}", method = RequestMethod.GET)
    public ModelAndView advertismentDetail(Model model, @PathVariable("adId") int adId, @Valid Advertisment adModel, BindingResult result,HttpServletRequest request) throws IOException {

        //System.out.println(request.getRealPath("/"));
        
        AdvertismentDaoImpl adi = new AdvertismentDaoImpl();
//        String saveDirectory = request.getServletContext().getContextPath()+"/web/adImages/1/"+adId+"/";
//       
//      System.out.println(saveDirectory);
//        ArrayList imageList = new ArrayList();
//        
//        File folder = new File(saveDirectory);
//        File[] listOfFiles = folder.listFiles();
//        for(int i = 0; i < listOfFiles.length; i++) {
//            if (listOfFiles[i].isFile()) {
//                
//                imageList.add(listOfFiles[i].getAbsolutePath());
//              
//            }
//        }

        Advertisment adBean = adi.findByAdvertismentId(adId);
       
        model.addAttribute("adModel", adBean);
        //model.addAttribute("imagePath",imageList);
        
        
        return new ModelAndView("pages/home/advertisementDetail");
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
