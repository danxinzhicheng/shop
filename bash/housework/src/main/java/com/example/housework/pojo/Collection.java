package com.example.housework.pojo;

import java.util.Date;

public class Collection {
    private int id;
    private User uid;
    private Service sid;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public Service getSid() {
        return sid;
    }

    public void setSid(Service sid) {
        this.sid = sid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
