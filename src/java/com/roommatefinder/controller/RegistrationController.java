/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.daoImpl.UserDaoImpl;
import com.roommatefinder.model.User;
import com.roommatefinder.validator.PasswordValidator;
import java.sql.Connection;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
    
  
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        System.out.println("Testing index");
        return new ModelAndView("/pages/index/index");
    }
    
   @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("/auth/registration", "user", new User());
    }
 
    
 
    
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user")User user,BindingResult result, ModelMap model) {
        
         userInsert = new UserDaoImpl();
        if (result.hasErrors()) {
            return "/auth/registration";
        }
        System.out.println("inside submit");
      
            if(userInsert.check(user)){
                userInsert.insert(user);
                model.addAttribute("message",null);
            }
            else
            {
               model.addAttribute("message","Email already exist");
                System.out.println("FAILL!!!!!");
            }
              
                    
              model.addAttribute("name", user.getName());
              model.addAttribute("email", user.getEmail());
              model.addAttribute("password", user.getPassword());
              
              
              //System.out.print(encoder.matches(pass,pass));
              
              return "auth/registration";
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
    
    
    public static boolean isValid(String email)
    {
        String val="^[A-Za-z0-9._%+-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,}$";
        Pattern checkReg = Pattern.compile(val);
        
        Matcher emailMatcher= checkReg.matcher(email);
        
        
        return emailMatcher.matches();
      
   
        
    } */
    
    





