package com.bajwa.SafeSkin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MakeUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long colorId;

    private String name;
    private Date expirDate;
    private Boolean isOpen;
    private Double size;
    private Long sku;
    private String color;

    public MakeUp() {
    }

    public MakeUp(long colorId, String name, Date expirDate, Boolean isOpen, Double size, String color) {
        this.colorId = colorId;
        this.name = name;
        this.expirDate = expirDate;
        this.isOpen = isOpen;
        this.size = size;
        this.color = color;
    }

    public MakeUp(long colorId, String name, Date expirDate, Boolean isOpen, Double size, Long sku, String color) {
        this.colorId = colorId;
        this.name = name;
        this.expirDate = expirDate;
        this.isOpen = isOpen;
        this.size = size;
        this.sku = sku;
        this.color = color;
    }

    public long getColorId() {
        return colorId;
    }

    public void setColorId(long colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public void setExpirDate(Date expirDate) {
        this.expirDate = expirDate;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
