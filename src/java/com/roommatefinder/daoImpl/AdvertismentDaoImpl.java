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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
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
                    + "CITY,POSTALCODE,GENDER,PETLOVER,DIET,SMOKER,ALCOHOL,RENT,BUILDINGTYPE,ROOMTYPE,NOOFROOMS,DESCRIPTION,FURNISHED)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            psmt = connection.prepareStatement(advInsertQuery);
            
            psmt.setString(1,advertisment.getAdTitle());
            psmt.setInt(2,1);
            
            psmt.setDate(3,getCurrentDate());
            psmt.setString(4,advertisment.getStreetAddress());
            psmt.setString(5,advertisment.getCountry());
            psmt.setString(6,advertisment.getProvince());
            psmt.setString(7,advertisment.getCity());
            psmt.setString(8,advertisment.getPostalCode());
            psmt.setString(9,advertisment.getGender());
            psmt.setString(10,advertisment.getPet());
            psmt.setString(11,advertisment.getDiet());
            psmt.setString(12,advertisment.getSmoke());
            psmt.setString(13,advertisment.getAlcohol());
            psmt.setDouble(14,advertisment.getRent());
            psmt.setString(15,advertisment.getBuildingType());
            psmt.setString(16,advertisment.getRoomType());
            psmt.setInt(17,advertisment.getNoOfRooms());
            psmt.setString(18,advertisment.getDescription());
            psmt.setString(19,advertisment.getFurnished());
            
            result = psmt.executeUpdate();
            
            
            Statement s = getConnection().createStatement();
            
            ResultSet rs = s.executeQuery("Select * from ADVERTISEMENT");
                if(rs.next())
                {
                    last_inserted_id = rs.getInt(1);
                   
                }            
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(last_inserted_id);
         return last_inserted_id;
    }

    @Override
    public Advertisment findByAdvertismentId(int adId) {
         Advertisment adBean = new Advertisment();
         ResultSet rs;
        try {
                      
            connection = getConnection();
            psmt = connection.prepareStatement("Select * from ADVERTISEMENT where ADID=?");
            psmt.setInt(1,adId);
            rs = psmt.executeQuery();
            while(rs.next()){
                adBean.setAdId(adId);
                adBean.setUserId(1);
                adBean.setAdPostDate(String.valueOf(rs.getDate("ADPOSTDATE")));
                adBean.setAdTitle(rs.getString("ADTITLE"));
                adBean.setAlcohol(rs.getString("ALCOHOL"));
                adBean.setBuildingType(rs.getString("BUILDINGTYPE"));
                adBean.setCity(rs.getString("CITY"));
                adBean.setCountry(rs.getString("COUNTRY"));
                adBean.setDescription(rs.getString("DESCRIPTION"));
                adBean.setDiet(rs.getString("DIET"));
                adBean.setGender(rs.getString("GENDER"));
                adBean.setNoOfRooms(rs.getInt("NOOFROOMS"));
                adBean.setPet(rs.getString("PETLOVER"));
                adBean.setPostalCode(rs.getString("POSTALCODE"));
                adBean.setProvince(rs.getString("PROVINCE"));
                adBean.setRent(rs.getDouble("RENT"));
                adBean.setRoomType(rs.getString("ROOMTYPE"));
                adBean.setSmoke(rs.getString("SMOKER"));
                adBean.setStreetAddress(rs.getString("STREETADDRESS"));
                
            }
            
            return adBean;
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return adBean;
    }

    private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
    
    @Override
    public Connection getConnection() {
        
        return ConnectionFactory.getConnection();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Advertisment> findByUserId(int userID) {
        List<Advertisment> advertismentList = new ArrayList<>();
        ResultSet advertisementResult;
        try {
            Advertisment adBean;
            
            
            connection = getConnection();
            psmt = connection.prepareStatement("Select ADID,ADTITLE,STREETADDRESS,ADPOSTDATE from ADVERTISEMENT where USERID = ?");
            psmt.setInt(1,userID);
            advertisementResult = psmt.executeQuery();
            while(advertisementResult.next()){
                adBean = new Advertisment();
                
                adBean.setAdId(advertisementResult.getInt("ADID"));
                adBean.setAdTitle(advertisementResult.getString("ADTITLE"));
                adBean.setStreetAddress(advertisementResult.getString("STREETADDRESS"));
                adBean.setAdPostDate(String.valueOf(advertisementResult.getDate("ADPOSTDATE")));
                
                advertismentList.add(adBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return advertismentList;
    }
    
}
