/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import org.json.JSONObject;

/**
 *
 * @author Farmaku
 */
public class Customers {

    private String customerID;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    public Customers() {
    }
    
    public Customers(JSONObject obj) {
        this.customerID = obj.optString("customerID");
        this.companyName = obj.optString("companyName");
        this.contactName = obj.optString("contactName");
        this.contactTitle = obj.optString("contactTitle");
        this.address = obj.optString("address");
        this.city = obj.optString("city");
        this.region = obj.optString("region");
        this.postalCode = obj.optString("postalCode");
        this.country = obj.optString("country");
        this.phone = obj.optString("phone");
        this.fax = obj.optString("fax");
    }

    public Customers(String customerID, String companyName, String contactName, String contactTitle, String address, String city, String region, String postalCode, String country, String phone, String fax) {
        this.customerID = customerID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
    }
    
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("customerID", customerID);
        json.put("companyName", companyName);
        json.put("contactName", contactName);
        json.put("contactTitle", contactTitle);
        json.put("address", address);
        json.put("city", city);
        json.put("region", region);
        json.put("postalCode", postalCode);
        json.put("country", country);
        json.put("phone", phone);
        json.put("fax", fax);
        return json;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Object getValue (int index){
        switch(index){
            case 0: return customerID;
            case 1: return companyName;
            case 2: return contactName;
            case 3: return contactTitle;
            case 4: return address;
            case 5: return city;
            case 6: return country;
            case 7: return postalCode;
            case 8: return country;
            case 9: return phone;
            case 10: return fax;
            default: return null;
        }
    }
    

}
