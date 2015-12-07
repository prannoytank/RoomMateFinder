/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Crusty
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
         HttpSession session = request.getSession(false);
         if(session.getAttribute("users")!=null){
             session.invalidate();
              return new ModelAndView("redirect:/index");
         }
         else
         {
             return new ModelAndView("redirect:/login");
         }
    }
}
