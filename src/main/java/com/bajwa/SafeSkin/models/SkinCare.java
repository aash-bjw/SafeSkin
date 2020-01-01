package com.bajwa.SafeSkin.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class SkinCare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long skinId;

    private String name;
    private Date expirDate;
    private Boolean isOpen;
    private Double size;
    private Long sku;

    public SkinCare() {
    }

    public SkinCare(String name, long skinId, Date expirDate, Boolean isOpen, Double size, Long sku) {
        this.skinId = skinId;
        this.expirDate = expirDate;
        this.isOpen = isOpen;
        this.size = size;
        this.sku = sku;
    }

    public SkinCare(String name, long skinId, Date expirDate, Boolean isOpen, Double size) {
        this.skinId = skinId;
        this.expirDate = expirDate;
        this.isOpen = isOpen;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSkinId() {
        return skinId;
    }

    public void setSkinId(long skinId) {
        this.skinId = skinId;
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
}
