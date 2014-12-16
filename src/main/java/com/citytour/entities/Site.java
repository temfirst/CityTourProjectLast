/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citytour.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="findAllSite", query="SELECT s FROM Site s")
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long site_id;
    private String name;
    private Double distance;
    private String category;
    private String address;   

    
    public Long getSite_id() {
        return site_id;
    }

    public void setSite_id(Long site_id) {
        this.site_id = site_id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.site_id == null && other.site_id != null) || (this.site_id != null && !this.site_id.equals(other.site_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Site{" + "site_id=" + site_id + ", name=" + name + ", distance=" + distance + ", category=" + category + ", address=" + address + '}';
    }

    
}
