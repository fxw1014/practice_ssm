package cn.itcast.test;

import cn.itcast.dao.OrdersDao;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrdersTest {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersDao od = ac.getBean(OrdersDao.class);
        PageHelper.startPage(2,4);
        System.out.println(od.findAll());
    }

    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersDao od = ac.getBean(OrdersDao.class);
        System.out.println(od.findById("0E7231DC797C486290E8713CA3C6ECCC"));
    }
}
