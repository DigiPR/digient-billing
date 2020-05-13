/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.digient.domain;

import org.springframework.core.style.ToStringCreator;

public class Billing {

    private String bId;
    private String cId;
    private String bDate;
    private String billAttachment;

    public Billing() {
    }

    public Billing(String bId, String cId, String bDate, String billAttachment) {
        super();
        this.bId = bId;
        this.cId = cId;
        this.bDate = bDate;
        this.billAttachment = billAttachment;
    }

    public String getBId() {
        return bId;
    }

    public void setBId(String bId) {
        this.bId = bId;
    }

    public Billing withBId(String bId) {
        this.bId = bId;
        return this;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public Billing withCId(String cId) {
        this.cId = cId;
        return this;
    }

    public String getBDate() {
        return bDate;
    }

    public void setBDate(String bDate) {
        this.bDate = bDate;
    }

    public Billing withBDate(String bDate) {
        this.bDate = bDate;
        return this;
    }

    public String getBillAttachment() {
        return billAttachment;
    }

    public void setBillAttachment(String billAttachment) {
        this.billAttachment = billAttachment;
    }

    public Billing withBillAttachment(String billAttachment) {
        this.billAttachment = billAttachment;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this).append("bId", bId).append("cId", cId).append("bDate", bDate).append("billAttachment", billAttachment).toString();
    }

}