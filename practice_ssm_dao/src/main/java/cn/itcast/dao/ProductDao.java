package cn.itcast.dao;

import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao {

    //查询所有产品
    public List<Product> findAll();

    //添加商品
    void save(Product product);
}
