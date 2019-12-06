package com.tk.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Cheng
 * @Date 2019/12/5 21:58
 */
public class User implements Serializable {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户生日
     */
    private Date birthday;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户
     */
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
