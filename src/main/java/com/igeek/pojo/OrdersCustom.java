package com.igeek.pojo;

import java.sql.Timestamp;
import java.util.List;

//OrdersCustom 是Orders类的拓展类
public class OrdersCustom extends Orders {

    //一对一关联 UserCustom
    private UserCustom userCustom;
    //一对多关联 OrderdetailCustom
    private List<OrderdetailCustom> detailList;

    public OrdersCustom() {
    }

    public OrdersCustom(Integer id, Integer userId, Timestamp createtime, String number, String note, UserCustom userCustom, List<OrderdetailCustom> detailList) {
        super(id, userId, createtime, number, note);
        this.userCustom = userCustom;
        this.detailList = detailList;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<OrderdetailCustom> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderdetailCustom> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "OrdersCustom{" +
                super.toString() +
                ", userCustom=" + userCustom +
                ", detailList=" + detailList +
                '}';
    }
}
