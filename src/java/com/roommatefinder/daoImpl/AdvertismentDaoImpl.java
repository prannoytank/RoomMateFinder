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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AshirwadTank
 */
public class AdvertismentDaoImpl implements AdvertismentDAO{
    
    Connection connection = null;
    PreparedStatement psmt = null;

    @Override
    public int insert(Advertisment advertisment) {
        
        int result = 0 ;
        int last_inserted_id = 0;
        try {
            connection = getConnection();
            String advInsertQuery = "insert into ADVERTISEMENT(ADTITLE,USERID,ADPOSTDATE,STREETADDRESS,COUNTRY,PROVINCE,"
                    + "CITY,POSTALCODE,GENDER,PETLOVER,DIET,SMOKER,ALCOHOL,RENT,BUILDINGTYPE,ROOMTYPE,NOOFROOMS,DESCRIPTION)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            psmt = connection.prepareStatement(advInsertQuery);
            
            psmt.setString(1,advertisment.getAdTitle());
            psmt.setInt(2,advertisment.getUserId());
            psmt.setDate(3, (java.sql.Date) new Date());
            psmt.setString(4,advertisment.getStreetAddress());
            psmt.setString(5,advertisment.getCountry());
            psmt.setString(6,advertisment.getProvince());
            psmt.setString(7,advertisment.getCity());
            psmt.setString(8,advertisment.getPostalCode());
            psmt.setString(9,advertisment.getGender());
            psmt.setString(10,advertisment.getPet());
            psmt.setString(11,advertisment.getDiet());
            psmt.setString(12,advertisment.getSmoke());
            psmt.setString(12,advertisment.getAlcohol());
            psmt.setDouble(12,advertisment.getRent());
            psmt.setString(13,advertisment.getBuildingType());
            psmt.setString(14,advertisment.getRoomType());
            psmt.setInt(15,advertisment.getNoOfRooms());
            psmt.setString(16,advertisment.getDescription());
            
            result = psmt.executeUpdate();
            
            ResultSet rs = psmt.getGeneratedKeys();
                if(rs.next())
                {
                    last_inserted_id = rs.getInt(1);
                }
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return last_inserted_id;
    }

    @Override
    public Advertisment findByAdvertismentId(int adId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Connection getConnection() {
        
        return ConnectionFactory.getConnection();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
