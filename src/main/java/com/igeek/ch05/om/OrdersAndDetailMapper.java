package com.igeek.ch05.om;

import com.igeek.pojo.OrdersCustom;

import java.util.List;

public interface OrdersAndDetailMapper {

    //查询订单及订单明细的信息
    public List<OrdersCustom> find();

}
