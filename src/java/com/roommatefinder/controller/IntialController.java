/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.AdvertismentDaoImpl;
import com.roommatefinder.model.Advertisment;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AshirwadTank
 */
@Controller
public class IntialController {

    @RequestMapping("/") // accepts url which has the context root path
    public ModelAndView landingPage() throws IOException {

        return new ModelAndView("pages/index/index");
    }

    @RequestMapping("/home") // For User Home Page
    public ModelAndView homePage(Model modelList,HttpServletRequest request) throws IOException {

        AdvertismentDaoImpl adi = new AdvertismentDaoImpl();
        
        List<Advertisment> adList = adi.findByUserId(1);
        
        modelList.addAttribute("advertisementList",adList);
        
        return new ModelAndView("pages/home/home");
    }

}
