package com.nagarro.Product.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Serviceability {

    @Id
    int pincode;

    int days;

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
