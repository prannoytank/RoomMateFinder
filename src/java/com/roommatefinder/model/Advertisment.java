/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roommatefinder.model;

/**
 *
 * @author AshirwadTank
 */
public class Advertisment {

    private int adId;
    private String adPostDate;
    private int userId;
    private String streetAddress;
    private String country;
    private String province;
    private String city;
    private String postalCode;
    private String latitude;
    private String longitude;
    private AdvertismentPreference advertismentPreference;

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdPostDate() {
        return adPostDate;
    }

    public void setAdPostDate(String adPostDate) {
        this.adPostDate = adPostDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public AdvertismentPreference getAdvertismentPreference() {
        return advertismentPreference;
    }

    public void setAdvertismentPreference(AdvertismentPreference advertismentPreference) {
        this.advertismentPreference = advertismentPreference;
    }

}
