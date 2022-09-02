/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tannn
 */
@Entity
@Table(name = "condition_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConditionDetails.findAll", query = "SELECT c FROM ConditionDetails c"),
    @NamedQuery(name = "ConditionDetails.findById", query = "SELECT c FROM ConditionDetails c WHERE c.id = :id"),
    @NamedQuery(name = "ConditionDetails.findByConditionName", query = "SELECT c FROM ConditionDetails c WHERE c.conditionName = :conditionName")})
public class ConditionDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "condition_name")
    private String conditionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conditionDetailsId")
    private List<Foods> foodsList;

    public ConditionDetails() {
    }

    public ConditionDetails(Integer id) {
        this.id = id;
    }

    public ConditionDetails(Integer id, String conditionName) {
        this.id = id;
        this.conditionName = conditionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    @XmlTransient
    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConditionDetails)) {
            return false;
        }
        ConditionDetails other = (ConditionDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndt.pojo.ConditionDetails[ id=" + id + " ]";
    }
    
}
