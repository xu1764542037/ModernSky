package com.laoxu.modernsky.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class User extends AbsSuperObject{

    private String id;
    private String password;
    private String name;
    private String sex;
    private String email;
    private String phone;
    private Date createDate;

    private String autograph;

    public Date getCreateDate() {
        this.createDate=new Date();
        java.sql.Date createDate = new java.sql.Date(this.createDate.getTime());
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
