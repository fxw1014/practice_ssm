package cn.itcast.dao;

import cn.itcast.domain.Orders;

import java.util.List;

public interface OrdersDao {
    //查询所有的订单
    public List<Orders> findAll();

    //根据订单id查询订单详情
    public Orders findById(String id);
}
