/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.CustomerFacade;
import com.citytour.entities.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Betty
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
     @Inject 
    private CustomerFacade customerEJB;
    private Customer custmer=new Customer();

    public CustomerFacade getCustomerEJB() {
        return customerEJB;
    }

    public void setCustomerEJB(CustomerFacade customerEJB) {
        this.customerEJB = customerEJB;
    }

    public Customer getCustmer() {
        return custmer;
    }

    public void setCustmer(Customer custmer) {
        this.custmer = custmer;
    }
    public String checkLogin(){
         
            
        if(customerEJB.findByUserName(custmer.getUserName(), custmer.getPassWord())==null)
            return "manageCustomer.xhtml";
        else
            return "index.xhtml";
    }
    

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
}
