package com.shopping.cart.controller;

import com.shopping.cart.domain.dto.ProductDto;
import com.shopping.cart.domain.entity.ProductEntity;
import com.shopping.cart.filter.ProductFilter;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createProduct(@RequestBody ProductDto productDto) {
        productDto.setAddedDate(new Date());
        productService.creatProduct(productDto);
        return "";
    }

    @PutMapping("/update")
    public String updateProducts(@RequestBody ProductDto productDto) {
        productService.updateProducts(productDto);
        return "";
    }

    @GetMapping("/getAll")
    public Iterable<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/getByFilter")
    public List<ProductEntity> searchProductsByFilter(@RequestBody ProductFilter filter){
        return productService.searchProductsByFilter(filter);
    }

    @PostMapping("/sortProducts/{sortBy}")
    public List<ProductEntity> sortProducts(@PathVariable String sortBy){
        return productService.sortProducts(sortBy);
    }

    @DeleteMapping("/{itemId}/delete")
    public String deleteProduct(@PathVariable Integer itemId) {
        productService.deleteProduct(itemId);
        return "";
    }
}