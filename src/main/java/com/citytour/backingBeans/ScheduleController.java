/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.SchedulesFacade;
import com.citytour.SessionBeans.SiteFacade;
import com.citytour.entities.Schedules;
import com.citytour.entities.Site;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "scheduleController")
@RequestScoped

public class ScheduleController {

    @Inject
    private SchedulesFacade scheduleEJB;

    @Inject
    private SiteFacade siteEJB;

    private Schedules sch = new Schedules();
    private List<Site> sites = new ArrayList<Site>();
    private List<Site> popedSites = new ArrayList<Site>();
    private Long[] temp;

    public List<Site> getPopedSites() {
        return popedSites = siteEJB.findAllSite();
    }

    public void setPopedSites(List<Site> popedSites) {
        this.popedSites = popedSites;
    }

    private List<String> str;

    public ScheduleController() {
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
        temp = new Long[popedSites.size()];
    }

    public Long[] getTemp() {
        return temp;
    }

    public void setTemp(Long[] temp) {
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

    public void addSites(Site si) {
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

    public String doCreateSchedule() {

        for (int j = 0; j < temp.length; j++) {
            sites.add(siteEJB.find(temp[j]));
            siteEJB.remove(siteEJB.find(temp[j]));
                    
        }
     
        sch.setSites(sites);
        scheduleEJB.create(sch);
        return "index";

    }

}
