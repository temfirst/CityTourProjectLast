/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.SessionBeans;

import com.citytour.entities.Tour;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CS Life
 */
@Stateless
public class TripFacade extends AbstractFacade<Tour> {
    @PersistenceContext(unitName = "cityTourdbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TripFacade() {
        super(Tour.class);
    }
    
    public Tour getPlanedTrips(Date temp){
        Query q = em.createQuery("select t from Tour t where t.date=:ftemp");
        q.setParameter("ftemp", temp);
        return (Tour) q.getSingleResult();
    }
}
