package cn.itcast.service;

import cn.itcast.domain.Product;

import java.util.List;

public interface ProductService {
    //查询所有商品
    public List<Product> findAll();

    //添加商品
    void save(Product product);
}
