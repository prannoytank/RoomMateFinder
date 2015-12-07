/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.UserDaoImpl;
import com.roommatefinder.model.User;
import com.roommatefinder.validator.PasswordValidator;
import java.io.File;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
@RequestMapping("/register")
public class RegistrationController {
     
    Connection connection;
     UserDaoImpl userInsert;
     
    @Autowired
    @Qualifier("passwordValidator")
    private PasswordValidator  validator;
    
    @Autowired
    ServletConfig ctx;
    
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
   
   @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("users")==null){
            return new ModelAndView("pages/auth/registration", "user", new User());
        }
        else
        {
            return new ModelAndView("redirect:/home");
        }
    }
 
    
 
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("user")User user,BindingResult result, ModelMap model,HttpServletRequest request) {
        
        ModelAndView mod = new ModelAndView();
         userInsert = new UserDaoImpl();
         User usx = new User();
        if (result.hasErrors()) {
            return new ModelAndView( "/pages/auth/registration");
        }
      
            if(userInsert.check(user)){
                userInsert.insert(user);
                usx = userInsert.getUsers(user.getEmail());
                String saveDirectory;
                saveDirectory = ctx.getServletContext().getRealPath("/")+"WEB-INF/";
        
                    File f = new File(saveDirectory+"/adImages/"+ (int)usx.getId());
                    if(f.exists() == false){
                         f.mkdirs();
                    }
                model.addAttribute("success", "Congratulation! You have registered successfully :)");
                model.addAttribute("message",null);
                mod.setViewName("redirect:/login");
                
               return mod;
            }
            else
            {
               model.addAttribute("message","Email already exist");
               model.addAttribute("success", null);
                
                return new ModelAndView("pages/auth/registration");
            }
  
              
         
        
    }
      
    }
    

    
/*@Target({TYPE, FIELD, ANNOTATION_TYPE}) 
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {   
    String message() default "Invalid email";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};
}   
    
    
    public static boolean isValid(String email)3399999
    {
        String val="^[A-Za-z0-9._%+-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,}$";
        Pattern checkReg = Pattern.compile(val);
        
        Matcher emailMatcher= checkReg.matcher(email);
        
        
        return emailMatcher.matches();
      
   
        
    } */
    
    





