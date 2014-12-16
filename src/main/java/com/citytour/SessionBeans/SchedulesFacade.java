/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.SessionBeans;

import com.citytour.entities.Schedules;
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
public class SchedulesFacade extends AbstractFacade<Schedules> {
    @PersistenceContext(unitName = "com.mycompany_CityTour")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SchedulesFacade() {
        super(Schedules.class);
    }
    
    public List<Schedules> getTripSchedules(Long id){
        Query q = em.createQuery("select s from Schedules s where s.id=:id");
        q.setParameter("id",id);
        return q.getResultList();
    }
}
