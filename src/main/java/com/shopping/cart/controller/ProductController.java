package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.filter.SortFilter;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct(@RequestBody ProductDto productDto) {
        productDto.setAddedDate(new Date());
        productService.creatProduct(productDto);
        return "";
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProducts(@RequestBody ProductDto productDto) {
        productService.updateProducts(productDto);
        return "";
    }

    @GetMapping("/getAll")
    public Iterable<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/getByFilter")
    public Iterable<ProductDto> searchProductsByFilter(@RequestBody ProductFilter filter){
        return productService.searchProductsByFilter(filter);
    }

    @PostMapping("/sortProducts")
    public Iterable<ProductDto> sortProducts(@RequestBody SortFilter filter){
        return productService.sortProducts(filter);
    }

    @DeleteMapping("/{itemId}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable Long itemId) {
        productService.deleteProduct(itemId);
        return "";
    }
}