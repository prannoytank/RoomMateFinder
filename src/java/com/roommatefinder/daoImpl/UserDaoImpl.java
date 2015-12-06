/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.daoImpl;

import com.roommatefinder.controller.RegistrationController;
import com.roommatefinder.dao.UserDAO;
import com.roommatefinder.model.User;
import com.roommatefinder.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author Crusty
 */
public class UserDaoImpl implements UserDAO{
Connection connection;
    @Override
    public int insert(User user) {
        int i =0;
               connection = ConnectionFactory.getConnection();
                    String query = "INSERT INTO USERMASTER(FULLNAME,EMAIL,PASSWORD) VALUES(?,?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, encryptPass(user.getPassword()));
                i = ps.executeUpdate();
                
            
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return i;
        
    }
    
@Override
    public boolean check(User user){
        connection=ConnectionFactory.getConnection();
        String query = "SELECT COUNT(USERID) FROM USERMASTER WHERE EMAIL LIKE ?";
    try {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getEmail());
        ResultSet rs =  ps.executeQuery();
        if(rs.next()){
           int val = rs.getInt(1);
           if(val==0){
               return true;
           }
           else
           {
               return false;
           }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }
     protected String encryptPass(String pass){
            
        BCryptPasswordEncoder passencode= new BCryptPasswordEncoder();
        String hashedPassword = passencode.encode(pass);
        return hashedPassword;

     }

    @Override
    public boolean check(String email) {
           connection=ConnectionFactory.getConnection();
        String query = "SELECT COUNT(USERID) FROM USERMASTER WHERE EMAIL LIKE ?";
    try {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs =  ps.executeQuery();
        if(rs.next()){
           int val = rs.getInt(1);
           if(val==0){
               return false;
           }
           else
           {
               return true;
           }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }
    
    
    
@Override
    public boolean isValidate(User user){
        connection=ConnectionFactory.getConnection();
        System.out.println("inside");
                
        String query = "SELECT * FROM USERMASTER WHERE EMAIL=?";
    try {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getEmail());
        
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            System.out.println("inside rs");
            String encPass = rs.getString("PASSWORD");
            
            BCryptPasswordEncoder passencode= new BCryptPasswordEncoder();
            if(passencode.matches(user.getPassword(), encPass)){
                return true;
            }
            else
            {
                System.out.println("fail pass test");
                return false;
            }
            
        }
        else
            return false;
        
    } catch (SQLException ex) {
        Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        return false;
    }
}
