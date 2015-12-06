/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.daoImpl;

import com.roommatefinder.dao.AdvertismentDAO;
import com.roommatefinder.model.Advertisment;
import com.roommatefinder.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author AshirwadTank
 */
public class AdvertismentDaoImpl implements AdvertismentDAO{

    @Override
    public void insert(Advertisment customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Advertisment findByAdvertismentId(int adId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResultSet searchAdvertisement(Advertisment adModel1){
       ResultSet rs=null;
        try{
     Connection con= ConnectionFactory.getConnection();
     Statement stmt=null;
     String query=null;
     String postalCode=adModel1.getPostalCode();
     if (postalCode==null){
        query="Select * from Advertisement where 'STREETADDRESS'='"+adModel1.getStreetAddress()+"'" ;
     }else{
         query="Select * from Advertisement where 'POSTALCODE'='"+adModel1.getPostalCode()+"'" ;
     }
     stmt=con.createStatement();
    rs= stmt.executeQuery(query);
     while(rs.next()){
         int id =rs.getInt("ADID");
         System.out.println("id is "+id);
     }
     }catch(Exception e){
         
     }
     
     return rs;  
    }
    
}
