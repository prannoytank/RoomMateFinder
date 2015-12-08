/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.controller;

import com.roommatefinder.model.User;
import com.roommatefinder.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Crusty
 */
@Controller
public class RegistrationController {
     
    Connection connection;
    
  
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        System.out.println("Testing index");
        return new ModelAndView("pages/index/index");
    }
    
   @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("/auth/registration", "user", new User());
    }
 
    
 
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user")User user,BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "/auth/registration";
        }
       String pass = user.getPassword();
        if(pass.equals(user.getPassconf())){
                    connection = ConnectionFactory.getConnection();
                    String query = "INSERT INTO(FULLNAME,EMAIL,PASSWORD) VALUES(?,?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, encryptPass(user.getPassword()));
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
              model.addAttribute("name", user.getName());
              model.addAttribute("email", user.getEmail());
              model.addAttribute("password", user.getPassword());
              return "auth/userviewtemp";
        }
        else
        {
            model.addAttribute("error","Password don't match!");
            return "/auth/registration";
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
    
    protected String encryptPass(String pass){
            
        BCryptPasswordEncoder passencode= new BCryptPasswordEncoder();
        String hashedPassword = passencode.encode(pass);
        return hashedPassword;

     }

}



