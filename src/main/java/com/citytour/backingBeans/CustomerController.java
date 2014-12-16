/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.CreditCardFacade;
import com.citytour.SessionBeans.CustomerFacade;
import com.citytour.entities.Address;
import com.citytour.entities.CreditCard;
import com.citytour.entities.CreditCardType;
import com.citytour.entities.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "customerController")
@SessionScoped

public class CustomerController implements Serializable {

    @Inject
    private CustomerFacade customerEJB;
    private Customer cust = new Customer();
    private Address address = new Address();

    @Inject
    private CreditCardFacade creditcardEJB;
    private List<CreditCard> creditCard = new ArrayList<CreditCard>();
    private CreditCard cr = new CreditCard();
    public CreditCardFacade getCreditcardEJB() {
        return creditcardEJB;
    }

    public void setCreditcardEJB(CreditCardFacade creditcardEJB) {
        this.creditcardEJB = creditcardEJB;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CustomerFacade getCustomerEJB() {
        return customerEJB;
    }

    public CreditCard getCr() {
        return cr;
    }

    public void setCr(CreditCard cr) {
        this.cr = cr;
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

    public String doCreateCustomer() {

        cr.setAddress(address);
        creditCard.add(cr);  
        cust.setCreditcards(creditCard);
        customerEJB.createCustomer(cust);
        return "login.xhtml";

    }

    public CustomerController() {
    }

    public CreditCardType[] getCreditCardTypeValues() {
        return CreditCardType.values();
    }

    public String savecustemer() {
        cust.setAddress(address);
        return "creditcard.xhtml";

    }
}
