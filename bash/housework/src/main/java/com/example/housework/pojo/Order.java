package com.example.housework.pojo;

import java.util.Date;

public class Order {
    private int id;
    private Service sid;
    private int uid;
    private Date activetime;
    private Date failuretime;
    private String address;
    private String area;
    private String name;
    private String  mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getSid() {
        return sid;
    }

    public void setSid(Service sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getActivetime() {
        return activetime;
    }

    public void setActivetime(Date activetime) {
        this.activetime = activetime;
    }

    public Date getFailuretime() {
        return failuretime;
    }

    public void setFailuretime(Date failuretime) {
        this.failuretime = failuretime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
