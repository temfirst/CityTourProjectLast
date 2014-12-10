/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.backingBeans;

import com.citytour.SessionBeans.CustomerFacade;
import com.citytour.SessionBeans.ScheduleFacade;
import com.citytour.entities.Customer;
import com.citytour.entities.Schedule;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


@Named(value = "customerController")
@RequestScoped

public class SchedualeController {
   
    @Inject 
    private ScheduleFacade ScheduleEJB;
    private Schedule sch=new Schedule();

    public ScheduleFacade getScheduleEJB() {
        return ScheduleEJB;
    }

    public void setScheduleEJB(ScheduleFacade ScheduleEJB) {
        this.ScheduleEJB = ScheduleEJB;
    }

    public Schedule getSch() {
        return sch;
    }

    public void setSch(Schedule sch) {
        this.sch = sch;
    }
  public String doCreateSchedual()
    {
      ScheduleEJB.create(sch);
      return "null";
    }
   
}
 