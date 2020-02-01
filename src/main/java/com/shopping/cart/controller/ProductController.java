package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.Product;
import com.shopping.cart.domain.dto.ShoppingCart;
import com.shopping.cart.service.ProductService;
import com.shopping.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;


@RestController
public class ProductController {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ProductController(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/product/create")
    public String  createProduct(@RequestParam String name, @RequestParam String productType) {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        Product product = new Product();
        product.setAddedDate(new Date());
        try {
            productService.creatProducts(product);
        } catch (Exception e) {
//            List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
//            modelAndView.addObject("productType", typeProducts);
//            modelAndView.addObject("productEntity", entity);
//            modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
        }
        return "";
    }

    @RequestMapping("/product/delete")
    public String  deleteProduct(@RequestParam String id ) {
        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
//            List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
//            modelAndView.addObject("productType", typeProducts);
//            modelAndView.addObject("productEntity", entity);
//            modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
            return "";
        }
        return "";
    }

    @RequestMapping("/product/update")
    public String updateProducts(@RequestParam String id ) {
        ModelAndView modelAndView = new ModelAndView("updateProducts");
        Product product = new Product();
        try {
            productService.updateProducts(product);
        } catch (Exception e) {
//            List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
//            modelAndView.addObject("productType", typeProducts);
//            modelAndView.addObject("productEntity", entity);
//            modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
            return "";
        }
        return "";

    }
}