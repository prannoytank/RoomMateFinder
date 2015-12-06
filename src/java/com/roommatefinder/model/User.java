/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Crusty
 */
public class User {
    @NotNull
    @NotEmpty(message = "Please enter your name")
    private String name;
    
    @NotNull
    @NotEmpty(message = "Please enter a password")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String password;
    
    @NotEmpty(message = "Please confirm your password")
    private String passconf;
    
    @NotNull
    @Email(message = "Not a valid email address")
    @NotEmpty(message = "Please enter your email address.")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassconf() {
        return passconf;
    }

    public void setPassconf(String passconf) {
        this.passconf = passconf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
