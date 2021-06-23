package com.laoxu.modernsky.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class AbsSuperObject implements Serializable {
    private String id;
    private String name;
    private Date Createdate = new Date();
    private String descripition;
    private String status;
//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreatedate() {
        return Createdate;
    }
    public void setCreatedate(Date createdate) {
        Createdate = createdate;
    }
    public String getDescripition() {
        return descripition;
    }
    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
