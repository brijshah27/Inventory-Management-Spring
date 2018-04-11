package org.teamInventory.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pname;
    private int pquantity;
    private float pprice;

    public product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPquantity() {
        return pquantity;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }

    public float getPprice() {
        return pprice;
    }

    public void setPprice(float pprice) {
        this.pprice = pprice;
    }
}
