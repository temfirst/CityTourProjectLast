/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.SchedulesFacade;
import com.citytour.SessionBeans.TourFacade;
import com.citytour.entities.PurchaseDescription;
import com.citytour.entities.Schedules;
import com.citytour.entities.Site;
import com.citytour.entities.Tour;
import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author User
 */
@ManagedBean(name = "dateController")
@SessionScoped
public class dateController {

    @Inject
    private TourFacade tourEJB;

    @Inject
    private SchedulesFacade schEJB;

    private Date temp;
    private String dateValue;
    private PurchaseDescription purchDesc;
    private List<Schedules> schs = new ArrayList<Schedules>();
    private List<Tour> tours = new ArrayList<Tour>();
    private List<Site> sites = new ArrayList<Site>();

    public TourFacade getTourEJB() {
        return tourEJB;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public List<Site> getSites() {
        return sites;
    }
    private List<String> schedulStr = new ArrayList<>();
    private List<PurchaseDescription> cartList=new ArrayList<>();
    private int  index;
    
    public dateController() {
    }

    public String dateFetcher() {

        tours = tourEJB.getPlanedTrips(temp);
        String str = String.valueOf(index);

        for (Tour t : tours) {
            //schs = schEJB.getTripSchedules(t.getSch().getId());
              schs.add(t.getSch());
            //str += t.getSch().getStartTime()+ " " + t.getSch().getEndTime();
            
            for (Site s : t.getSch().getSites()) {
               sites.add(s);
                //str += s.getName() + s.getAddress();
               str+=s.getName();
            }
            
            schedulStr.add(str);
        }
        
        return "selectSchedule";
    }
    
    public String loadingCart(int index)
    {
       int quantity=3;//try to accept the quanity from combo or other means
       
       PurchaseDescription purchDesc =new PurchaseDescription();
       
       purchDesc.setDescription(schedulStr.get(index));
       purchDesc.setQuantity(quantity);
       purchDesc.setUnitPrice(tours.get(index).getSch().getPrice());
       purchDesc.setTax((tours.get(index).getSch().getPrice()*quantity)*0.01);
       
       cartList.add(purchDesc);
       
       return "purchaseSummary";
    }


    public SchedulesFacade getSchEJB() {
        return schEJB;
    }

    public void setSchEJB(SchedulesFacade schEJB) {
        this.schEJB = schEJB;
    }

    public List<Schedules> getSchs() {
        return schs;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public String getDateValue() {
        return dateValue;
    }

    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
    }

    public void setSchs(List<Schedules> schs) {
        this.schs = schs;
    }

    public PurchaseDescription getPurchDesc() {
        return purchDesc;
    }

    public void setPurchDesc(PurchaseDescription purchDesc) {
        this.purchDesc = purchDesc;
    }

    public TourFacade getTripEJB() {
        return tourEJB;
    }

    public void setTourEJB(TourFacade tripEJB) {
        this.tourEJB = tripEJB;
    }

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
    }

    public List<String> getSchedulStr() {
        return schedulStr;
    }

    public void setSchedulStr(List<String> schedulStr) {
        this.schedulStr = schedulStr;
    }

    public List<PurchaseDescription> getCartList() {
        return cartList;
    }

    public void setCartList(List<PurchaseDescription> cartList) {
        this.cartList = cartList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
