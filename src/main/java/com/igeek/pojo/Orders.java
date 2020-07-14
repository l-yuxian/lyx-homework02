package com.igeek.pojo;

import java.sql.Timestamp;

//订单
public class Orders {

    private Integer id;
    private Integer userId;
    private Timestamp createtime;
    private String number;
    private String note;

    public Orders() {
    }

    public Orders(Integer id, Integer userId, Timestamp createtime, String number, String note) {
        this.id = id;
        this.userId = userId;
        this.createtime = createtime;
        this.number = number;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", createtime=" + createtime +
                ", number='" + number + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
