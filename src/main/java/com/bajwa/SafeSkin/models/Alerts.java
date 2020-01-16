package com.bajwa.SafeSkin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dateId;
    private Date expDate;

    public Date getDate() {
        return expDate;
    }

    public void setDate(Date date) {
        this.expDate = expDate;
    }
}
