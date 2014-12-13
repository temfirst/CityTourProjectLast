/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author CS Life
 */
@Entity
@NamedQuery(name="findAllCust", query="SELECT c FROM Customer c")

public class Customer extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int sitNo;
    @OneToMany
    @JoinTable(name="jnd_cut_tour", joinColumns=@JoinColumn(name="cut_fk"),
            inverseJoinColumns = @JoinColumn(name="tour_fk"))
    private List<Tour> booktrips; 
    private boolean certified;
    private String userName;
    private String passWord;
    @OneToMany
    @JoinTable(name="jnd_cut_Card", joinColumns=@JoinColumn(name="cut_fk"),
            inverseJoinColumns = @JoinColumn(name="credit_fk"))
    private List<CreditCard> creditcards; 

    public List<CreditCard> getCreditcards() {
        return creditcards;
    }

    public void setCreditcards(List<CreditCard> creditcards) {
        this.creditcards = creditcards;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
            

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public int getSitNo() {
        return sitNo;
    }

    public void setSitNo(int sitNo) {
        this.sitNo = sitNo;
    }

    public List<Tour> getBooktrips() {
        return booktrips;
    }

    public void setBooktrips(List<Tour> booktrips) {
        this.booktrips = booktrips;
    }

   
    
    

    
    
}
