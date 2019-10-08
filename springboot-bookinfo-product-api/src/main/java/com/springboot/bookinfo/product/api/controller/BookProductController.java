package com.springboot.bookinfo.product.api.controller;

import com.springboot.bookinfo.product.BookProduct;
import com.springboot.bookinfo.product.service.BookProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类BookProductController的实现描述: BookProductController
 *
 * @author hongyang 2019-10-08 19:45
 */
@RestController
public class BookProductController {

    private final BookProductService bookProductService;

    @Autowired
    public BookProductController(BookProductService bookProductService) {
        this.bookProductService = bookProductService;
    }

    @RequestMapping("/api/products/{productId}")
    public BookProduct getBookProduct(@PathVariable(value = "productId") Long productId) {

        return bookProductService.getBookProductById(productId);

    }

}
