package com.shopping.cart.controller;

import com.shopping.cart.model.domain.dto.ProductDto;
import com.shopping.cart.model.domain.entity.ProductEntity;
import com.shopping.cart.model.filter.ProductFilter;
//import com.shopping.cart.model.filter.SortFilter;
import com.shopping.cart.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
//    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        productDto.setCreatedDate(new Date());
        return productService.creatProduct(productDto);
    }

    @PutMapping("/update")
//    @PreAuthorize("hasRole('ADMIN')")
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
//    @PreAuthorize("hasRole('ADMIN')")
    public Long deleteProduct(@PathVariable Long itemId) {
        return productService.deleteProduct(itemId);
    }
}