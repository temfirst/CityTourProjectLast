/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.SessionBeans;

import com.citytour.entities.Tour;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class TourFacade extends AbstractFacade<Tour> {
    @PersistenceContext(unitName = "com.mycompany_CityTour")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TourFacade() {
        super(Tour.class);
    }
    
    public List <Tour> getPlanedTrips(Date temp){
        Query q = em.createQuery("select t from Tour t where t.date=:ftemp");
        q.setParameter("ftemp", temp);
        return q.getResultList(); 
    }
}
