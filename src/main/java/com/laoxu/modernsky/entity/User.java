package com.laoxu.modernsky.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class User extends AbsSuperObject{
    /**
     * 用户账号
     */
    private String id;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户创建时间
     */
    private Date createDate;


    public Date getCreateDate() {
        this.createDate=new Date();
        java.sql.Date createDate = new java.sql.Date(this.createDate.getTime());
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
