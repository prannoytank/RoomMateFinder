package com.roommatefinder.controller;

import com.roommatefinder.model.User;
import com.roommatefinder.daoImpl.UserDaoImpl;
import com.roommatefinder.validator.SettingsValidator;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DianaA
 */
@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    @Qualifier("settingsValidator")
    private SettingsValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    //session variable to be added
    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model, HttpServletRequest request) {
        UserDaoImpl userdao = new UserDaoImpl();
        User userModel = new User();
         User user = (User) request.getSession().getAttribute("users");
        double userId = user.getId();
         userModel.setId(userId);
        try {
            ResultSet rs = userdao.getUserSettings(userId);
            while (rs.next()) {
                userModel.setEmail(rs.getString("EMAIL"));
                userModel.setPostalCode(rs.getString("POSTALCODE"));
                userModel.setStreetAddress(rs.getString("STREETADDRESS"));
                userModel.setCountry(rs.getString("COUNTRY"));
                userModel.setProvince(rs.getString("PROVINCE"));
                userModel.setCity(rs.getString("CITY"));
                userModel.setActive(rs.getString("ACTIVE"));
                userModel.setName(rs.getString("FULLNAME"));
                userModel.setGender(rs.getString("GENDER"));
                userModel.setContact(rs.getString("CONTACT"));
               }
            model.addAttribute("userModel", userModel);
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "pages/home/settings";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("userModel") @Valid User userModel, BindingResult result) 
    {
       // model.addAttribute("userModel", userModel);
        //initModelList(model);
        String returnVal = "successForm";
        if (result.hasErrors()) {
            returnVal = "pages/home/settings";
            System.out.println("in has errors");
                   } else {
            UserDaoImpl userdao = new UserDaoImpl();
            int a = userdao.updateSettings(userModel);
            
        }

        return "pages/home/home";
    }

}
