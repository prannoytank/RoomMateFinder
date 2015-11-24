/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AshirwadTank
 */
@Controller
public class IntialController {

    @RequestMapping("/") // accepts url which has the context root path
    public ModelAndView landingPage() throws IOException {

        return new ModelAndView("jsp/index");
    }

    @RequestMapping("/home") // accepts url which has the context root path
    public ModelAndView homePage() throws IOException {

        return new ModelAndView("pages/home/home");
    }

}
