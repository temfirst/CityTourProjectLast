/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.CustomerFacade;
import com.citytour.SessionBeans.SchedulesFacade;
import com.citytour.SessionBeans.SiteFacade;
import com.citytour.entities.Customer;
import com.citytour.entities.Schedules;
import com.citytour.entities.Site;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


@Named(value = "scheduleController")
@SessionScoped

public class ScheduleController {
   
    @Inject 
    private SchedulesFacade scheduleEJB;
    
    @Inject
    private SiteFacade siteEJB;
    
    private Schedules sch=new Schedules();
    private List<Site> sites = new ArrayList<Site>();
    private List<Site>popedSites =  new ArrayList<Site>();
    private Long [] temp;
    
    
    public List<Site> getPopedSites() {
        return popedSites = siteEJB.findAllSite();
    }

    public void setPopedSites(List<Site> popedSites) {
        this.popedSites = popedSites;
    }
    
    private List<String> str;    
    
    public ScheduleController(){
    }

    public List<String> getStr() {
        return str;
    }

    public void setStr(List<String> str) {
        this.str = str;
    }
       

    public SiteFacade getSiteEJB() {
        return siteEJB;
    }
    
    @PostConstruct 
    public void popedSites() { 
        popedSites = siteEJB.findAllSite();
        temp = new Long [popedSites.size()];
    } 

    public Long [] getTemp() {
        return temp;
    }

    public void setTemp(Long [] temp) {
        this.temp = temp;
    }  
    
    
    public void setSiteEJB(SiteFacade siteEJB) {
        this.siteEJB = siteEJB;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

   

    public SchedulesFacade getScheduleEJB() {
        return scheduleEJB;
    }
    
    public void addSites(Site si){
        sites.add(si);        
    }

    public void setScheduleEJB(SchedulesFacade scheduleEJB) {
        this.scheduleEJB = scheduleEJB;
    }

    public Schedules getSch() {
        return sch;
    }

    public void setSch(Schedules sch) {
        this.sch = sch;
    }
    
    public List<Site> prepareSites(){
        for(int i=0; i<popedSites.size()-1;i++){
            if(popedSites.get(i).getSite_id()== temp[i])
                sites.add(popedSites.get(i));
        }
        
        return sites;
    }
    
    public String doCreateSchedule()
    {
      
      sch.setSites(prepareSites());
      scheduleEJB.create(sch);
      return "index"; 
    }
    
    
    
}
