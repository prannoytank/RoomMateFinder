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
        System.out.println(city);
        List<Advertisment> list = advs.findByCity(city);

        model.addAttribute("searchdata", list);
        return new ModelAndView("pages/index/searchresult");
    }

    @RequestMapping("/home") // For User Home Page
    public ModelAndView homePage() throws IOException {

        return new ModelAndView("pages/home/home");
    }

}
