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
       
    }

    @Override
    public List<Advertisment> findByCity(String city) {
        Advertisment ads;
       connection=getConnection();
       List<Advertisment> ls = new ArrayList<>();
       String query = "SELECT * FROM advertisement WHERE CITY=?";
       PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
             ps.setString(1, city);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 ads =  new Advertisment();
                 
                 ads.setAdId(rs.getInt("ADID"));
                 ads.setAdPostDate(String.valueOf(rs.getDate("ADPOSTDATE")));
                 ads.setAdTitle(rs.getString("ADTITLE"));
                 ads.setStreetAddress(rs.getString("STREETADDRESS"));
                                
                 ls.add(ads);
                 System.out.println(ls.size());
             }
          
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return ls;
       
    }
    
    @Override
    public ResultSet searchAdvertisement(Advertisment adModel1){
    ResultSet rs=null;
       
     try{
     Connection con= ConnectionFactory.getConnection();
     String query="Select * from Advertisement where CITY=? and BUILDINGTYPE=? and NOOFROOMS = ? and GENDER=? and PETLOVER=? and DIET=? and SMOKER = ? and ALCOHOL=?" ;
     PreparedStatement preparedStatement = con.prepareStatement(query);
     
     preparedStatement.setString(1,adModel1.getCity() );
     preparedStatement.setString(2,adModel1.getBuildingType() );
     preparedStatement.setInt(3,adModel1.getNoOfRooms() );
     preparedStatement.setString(4,adModel1.getGender() );
     preparedStatement.setString(5,adModel1.getPet() );
     preparedStatement.setString(6,adModel1.getDiet() );
     preparedStatement.setString(7,adModel1.getSmoke());
     preparedStatement.setString(8,adModel1.getAlcohol());
     
     rs= preparedStatement.executeQuery();
     }catch(Exception e){
         
     }
     
     return rs;  
    }

    @Override
    public List<Advertisment> findByUserId(int userID) {
        List<Advertisment> userAdList= new ArrayList<>();
        try {
            
            Connection con =  ConnectionFactory.getConnection();
            Advertisment adBean ;
            
            PreparedStatement ps =con.prepareStatement("Select ADID,ADTITLE,ADPOSTDATE,STREETADDRESS from ADVERTISEMENT where USERID=?");
            ps.setInt(1,userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               // System.out.println(rs.getInt("ADID"));
                adBean = new Advertisment();
                
                adBean.setAdId(rs.getInt("ADID"));
                adBean.setAdPostDate(String.valueOf(rs.getDate("ADPOSTDATE")));
                adBean.setAdTitle(rs.getString("ADTITLE"));
                adBean.setStreetAddress(rs.getString("STREETADDRESS"));
                
                userAdList.add(adBean);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdvertismentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(userAdList.size());
        return userAdList;
    }
    
}
