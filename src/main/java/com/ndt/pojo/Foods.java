/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tannn
 */
@Entity
@Table(name = "foods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f"),
    @NamedQuery(name = "Foods.findById", query = "SELECT f FROM Foods f WHERE f.id = :id"),
    @NamedQuery(name = "Foods.findByName", query = "SELECT f FROM Foods f WHERE f.name = :name"),
    @NamedQuery(name = "Foods.findByPrice", query = "SELECT f FROM Foods f WHERE f.price = :price"),
    @NamedQuery(name = "Foods.findBySellTime", query = "SELECT f FROM Foods f WHERE f.sellTime = :sellTime"),
    @NamedQuery(name = "Foods.findByImgFood", query = "SELECT f FROM Foods f WHERE f.imgFood = :imgFood")})
public class Foods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;
    @Column(name = "sell_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellTime;
    @Size(max = 200)
    @Column(name = "img_food")
    private String imgFood;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Category categoryId;
    @JoinColumn(name = "condition_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private ConditionDetails conditionDetailsId;
    @JoinColumn(name = "stores_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Stores storesId;

    public Foods() {
    }

    public Foods(Integer id) {
        this.id = id;
    }

    public Foods(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public String getImgFood() {
        return imgFood;
    }

    public void setImgFood(String imgFood) {
        this.imgFood = imgFood;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public ConditionDetails getConditionDetailsId() {
        return conditionDetailsId;
    }

    public void setConditionDetailsId(ConditionDetails conditionDetailsId) {
        this.conditionDetailsId = conditionDetailsId;
    }

    public Stores getStoresId() {
        return storesId;
    }

    public void setStoresId(Stores storesId) {
        this.storesId = storesId;
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
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndt.pojo.Foods[ id=" + id + " ]";
    }
    
}
