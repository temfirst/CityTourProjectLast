

package com.citytour.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tour_id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double price;
    private int numb_of_visitors;
    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   

    public int getNumb_of_visitors() {
        return numb_of_visitors;
    }

    public void setNumb_of_visitors(int numb_of_visitors) {
        this.numb_of_visitors = numb_of_visitors;
    }

    
    
 

    
    
}
