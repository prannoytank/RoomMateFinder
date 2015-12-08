/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.dao;

import com.roommatefinder.model.Advertisment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;



/**
 *
 * @author AshirwadTank
 */
public interface AdvertismentDAO {
    

    public int insert(Advertisment customer);

    public Advertisment findByAdvertismentId(int adId);
    public List<Advertisment> findByCity(String city);
    
    public List<Advertisment> findByUserId(int userID);
    
    public Connection getConnection();
    
    public ResultSet searchAdvertisement(Advertisment amodel);
}
