/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;


import com.citytour.SessionBeans.SiteFacade;
import com.citytour.entities.Site;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author CS Life
 */
@Named(value = "siteController")
@RequestScoped
public class siteController {

    @Inject 
    private SiteFacade siteEJB;
    private Site site=new Site();
    private List<Site> siteList=new ArrayList<>(); 
    public SiteFacade getSiteEJB() {
        return siteEJB;
    }

    public void setSiteEJB(SiteFacade siteEJB) {
        this.siteEJB = siteEJB;
    }

    public Site getSite() {
        return site;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public void setSite(Site site) {
        this.site = site;
    }    
      
    public String doCreateSite()
    {
      siteEJB.createSite(site);
      return "Admin.xhtml";
    }
    
    public List<Site> doFindAllSite()
    {
       return siteList =siteEJB.findAllSite();
    }
    public siteController() {
    }
    
}
