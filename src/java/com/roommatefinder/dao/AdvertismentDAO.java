/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.dao;

import com.roommatefinder.model.Advertisment;
import java.sql.Connection;



/**
 *
 * @author AshirwadTank
 */
public interface AdvertismentDAO {
    

    public int insert(Advertisment customer);

    public Advertisment findByAdvertismentId(int adId);
    
    public Connection getConnection();
}
