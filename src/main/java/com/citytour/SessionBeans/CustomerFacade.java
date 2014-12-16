/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.SessionBeans;

import com.citytour.entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CS Life
 */
@Named
@Stateless
public class CustomerFacade extends AbstractFacade<Customer>  {
    @PersistenceContext(unitName = "cityTourdbPU")
    private EntityManager em;
    
    public Customer createCustomer(Customer cust)
    {
        em.persist(cust);
        return cust;
    }       
    public List<Customer> findAllCustomers()
    {
        return em.createNamedQuery("findAllCust",Customer.class).getResultList();
        
    }
    public Customer findBookByID(Long id)
    {
        return em.find(Customer.class, id);
    }  
     public Customer findByUserName(String userName,String passWord)
    {
        Customer customer = new Customer();
        Query query= em.createQuery("select c from Customer c where c.userName=:usern and c.passWord=:passWord");
        query.setParameter("usern", userName);
        query.setParameter("passWord", passWord);
        customer=(Customer) query.getSingleResult();
        return customer;
    }      
 
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
}
