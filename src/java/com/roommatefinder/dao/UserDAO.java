/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.dao;

import com.roommatefinder.model.User;

/**
 *
 * @author Crusty
 */
public interface UserDAO {
    
    public int insert(User user);
    public boolean check(User user);
    public boolean check(String email);
    public boolean isValidate(User user);
}
