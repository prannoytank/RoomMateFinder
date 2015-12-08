/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.UserDaoImpl;
import com.roommatefinder.model.User;
import com.roommatefinder.validator.LoginValidator;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Crusty
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    Connection connection;
    UserDaoImpl userSelect;
    
    @Autowired
    @Qualifier("loginValidator")
    private LoginValidator  validator;
    
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(HttpServletRequest request) {
         HttpSession session = request.getSession(false);
         if(session.getAttribute("users")==null){
            return new ModelAndView("pages/auth/login", "user", new User());
         }
         else{
             return new ModelAndView("redirect:/home");
         }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("user")User user,BindingResult result, ModelMap model,HttpServletRequest request) {
        //System.out.println("inside");
        ModelAndView mod = new ModelAndView("");
        User usv = new User();
        userSelect = new UserDaoImpl();
        if (result.hasErrors()) {
                 

            return new ModelAndView("/pages/auth/login");
        }
        
        if(userSelect.check(user.getEmail())){
            
                if(userSelect.isValidate(user)){
                    model.addAttribute("message",null);
                    usv = userSelect.getUsers(user.getEmail());
                    request.getSession().setAttribute("users", usv);
                    mod.setViewName("redirect:/home");

                    return mod;
                }
                else
                {
                    model.addAttribute("message","Email id or Password is wrong");

                        
                        return new ModelAndView("pages/auth/login");
                }
        }
        else{
             model.addAttribute("message","Email id does not exist please register! ");

                      
                        return new ModelAndView("pages/auth/login");
        }
   
    }
    
    
    
    
    
}
