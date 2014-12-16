/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.SessionBeans;

import com.citytour.entities.Customer;
import com.citytour.entities.Site;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author CS Life
 */
@Stateless
public class SiteFacade extends AbstractFacade<Site> {
    @PersistenceContext(unitName = "cityTourdbPU")
    private EntityManager em;

    
    public Site createSite(Site site)
    {
        em.persist(site);
        return site;
    }       
    public List<Site> findAllSite()
    {
        return em.createNamedQuery("findAllSite",Site.class).getResultList();
        
    }
       

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SiteFacade() {
        super(Site.class);
    }
    
}
