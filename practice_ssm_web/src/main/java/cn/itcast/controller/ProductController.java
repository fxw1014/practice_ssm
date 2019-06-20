package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Product> productList = productService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("productList",productList);
        mav.setViewName("product-list");
        return mav;
    }

    @RequestMapping("/save.do")
    public String add(Product product){

        productService.save(product);
        return "redirect:findAll.do";
    }
}
