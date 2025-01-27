package org.islom.dars111.controller;

import org.islom.dars111.payload.ProductDto;
import org.islom.dars111.payload.Result;
import org.islom.dars111.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductController {
    ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto) {
        return productService.addroduct(productDto);
    }
}
