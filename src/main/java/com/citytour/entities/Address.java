/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author CS Life
 */
@Embeddable
@Access(AccessType.FIELD)
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String address_Line1;
    private String address_Line2;
    private String city;
    private String county;
    private String state;
    private String zip_Code;
    private String phone_Number;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getAddress_Line1() {
        return address_Line1;
    }

    public void setAddress_Line1(String address_Line1) {
        this.address_Line1 = address_Line1;
    }

    public String getAddress_Line2() {
        return address_Line2;
    }

    public void setAddress_Line2(String address_Line2) {
        this.address_Line2 = address_Line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_Code() {
        return zip_Code;
    }

    public void setZip_Code(String zip_Code) {
        this.zip_Code = zip_Code;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }
  
    
            
            
    
    
}
