package com.dbcoding.mall.model;

import java.math.BigDecimal;
import java.util.Date;

public class SellChannel {
    private String id;

    private String code;

    private String name;

    private Integer freezeDay;

    private BigDecimal drawDemand;

    private BigDecimal money;

    private Boolean isOpenSell;

    private BigDecimal sellPrice;

    private Integer status;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Integer isDelete;

    private Integer isSelfPickup;

    private Integer isSkipTencent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFreezeDay() {
        return freezeDay;
    }

    public void setFreezeDay(Integer freezeDay) {
        this.freezeDay = freezeDay;
    }

    public BigDecimal getDrawDemand() {
        return drawDemand;
    }

    public void setDrawDemand(BigDecimal drawDemand) {
        this.drawDemand = drawDemand;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Boolean getIsOpenSell() {
        return isOpenSell;
    }

    public void setIsOpenSell(Boolean isOpenSell) {
        this.isOpenSell = isOpenSell;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsSelfPickup() {
        return isSelfPickup;
    }

    public void setIsSelfPickup(Integer isSelfPickup) {
        this.isSelfPickup = isSelfPickup;
    }

    public Integer getIsSkipTencent() {
        return isSkipTencent;
    }

    public void setIsSkipTencent(Integer isSkipTencent) {
        this.isSkipTencent = isSkipTencent;
    }
}