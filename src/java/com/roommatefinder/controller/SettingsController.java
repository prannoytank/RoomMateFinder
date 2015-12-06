package com.roommatefinder.controller;

import com.roommatefinder.model.User;
import com.roommatefinder.model.Advertisment;
import com.roommatefinder.validator.AdvertismentValidator;
import java.util.ArrayList;
import java.util.List;
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
    public String initForm(Model model) {
        User userModel = new User();
        model.addAttribute("userModel", userModel);
   
        return "pages/home/settings";
    }

}
