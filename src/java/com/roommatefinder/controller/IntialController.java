/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.AdvertismentDaoImpl;
import com.roommatefinder.model.Advertisment;
import com.roommatefinder.model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AshirwadTank
 */
@Controller
public class IntialController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView landingPage() throws IOException {

        return new ModelAndView("pages/index/index");
    }

    @RequestMapping(value = "/searchindex", method = RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request, Model model) throws IOException {
       
        String city = request.getParameter("cities");
        AdvertismentDaoImpl advs = new AdvertismentDaoImpl();
       
        List<Advertisment> list = advs.findByCity(city);

        model.addAttribute("searchdata", list);
        return new ModelAndView("pages/index/searchresult");
    }

    @RequestMapping("/home") // For User Home Page
    public ModelAndView homePage(Model modelList,HttpServletRequest request) throws IOException {
         User user;
         HttpSession session = request.getSession(false);
         if(session.getAttribute("users")==null){
            return new ModelAndView("redirect:/login", "user", new User());
         }
         else{
         user = (User) request.getSession().getAttribute("users");
         }
       // System.out.println((int)user.getId());
        
        AdvertismentDaoImpl adi = new AdvertismentDaoImpl();
        
        List<Advertisment> adList = adi.findByUserId((int)user.getId());
        
        modelList.addAttribute("advertisementList",adList);
        
        return new ModelAndView("pages/home/home");
    }

}
