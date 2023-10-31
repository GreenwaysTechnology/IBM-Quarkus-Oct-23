package com.ibm.activerecord.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Customer extends PanacheEntity {
    //Column Names
    @Column(name = "name")
    public String name;
    @Column(name="city")
    public String city;
}
