/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.dao;

import com.roommatefinder.model.Advertisment;

/**
 *
 * @author AshirwadTank
 */
public interface AdvertismentDAO {

    public void insert(Advertisment customer);

    public Advertisment findByAdvertismentId(int adId);
}
