package cn.itcast.service;

import cn.itcast.domain.Orders;

import java.util.List;

public interface OrderService {

    //查询所有的订单
    public List<Orders> findAll(int page,int pageSize);

    //根据订单id查询订单详情
    Orders findById(String id);
}
