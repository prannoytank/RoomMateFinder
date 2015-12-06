package com.roommatefinder.controller;

import com.roommatefinder.model.User;
import com.roommatefinder.daoImpl.UserDaoImpl;
import com.roommatefinder.model.Advertisment;
import com.roommatefinder.validator.AdvertismentValidator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model, HttpServletRequest request) {
        UserDaoImpl userdao = new UserDaoImpl();
        User userModel = new User();

        int userId = 1;
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
                userModel.setDateOfBirth(rs.getDate("DATEOFBIRTH"));

            }

            model.addAttribute("userModel", userModel);
            System.out.println(userModel.getCountry());
        } catch (SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "pages/home/settings";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute("userModel") @Valid User userModel, BindingResult result) 
    {
        model.addAttribute("userModel", userModel);
        //initModelList(model);
        String returnVal = "successForm";
        if (result.hasErrors()) {
            returnVal = "pages/home/advancedSearch";
            //return "pages/home/advancedSearch";
        } else {
            UserDaoImpl userdao = new UserDaoImpl();
            int a = userdao.updateSettings(1, userModel);
        }

        return "pages/home/advancedSearch";
    }

}
