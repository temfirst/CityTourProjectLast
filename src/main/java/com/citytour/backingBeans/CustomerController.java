/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.CustomerFacade;
import com.citytour.entities.Customer;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


@Named(value = "customerController")
@RequestScoped

public class CustomerController {
   
    @Inject 
    private CustomerFacade customerEJB;
    private Customer cust=new Customer();

    public CustomerFacade getCustomerEJB() {
        return customerEJB;
    }

    public void setCustomerEJB(CustomerFacade customerEJB) {
        this.customerEJB = customerEJB;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
    
      
    public String doCreateCustomer()
    {
      customerEJB.createCustomer(cust);
      return "null";
    }
   
     public CustomerController() {
    }
     
    public void populateTable(){
        
    }
}
