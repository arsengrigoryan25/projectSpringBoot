package com.shopping.cart.controller;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.filter.ProductFilter;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        productDto.setCreatedDate(new Date());
        return productService.creatProduct(productDto);
    }

    @PutMapping("/update")
    public ProductDto updateProducts(@RequestBody ProductDto productDto) {
        return productService.updateProducts(productDto);
    }

    @GetMapping("/getAll")
    public Iterable<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/getByFilter")
    public Iterable<ProductDto> getProductsByFilter(@RequestBody ProductFilter filter){
        return productService.getProductsByFilter(filter);
    }

//    @PostMapping("/sortProducts")
//    public Iterable<ProductDto> sortProducts(@RequestBody SortFilter filter){
//        return productService.sortProducts(filter);
//    }

    @DeleteMapping("/delete/{itemId}")
    public Long deleteProduct(@PathVariable Long itemId) {
        return productService.deleteProduct(itemId);
    }
}