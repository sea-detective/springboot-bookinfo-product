package com.springboot.bookinfo.product.service;

import com.google.common.base.Preconditions;
import com.springboot.bookinfo.details.BookDetail;
import com.springboot.bookinfo.details.service.BookDetailService;
import com.springboot.bookinfo.product.BookProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类BookProductService的实现描述: BookProductService
 *
 * @author hongyang 2019-10-08 19:46
 */
@Service
public class BookProductService {

    private final BookDetailService bookDetailService;

    @Autowired
    public BookProductService(BookDetailService bookDetailService) {
        this.bookDetailService = bookDetailService;
    }

    public BookProduct getBookProductById(Long id) {

        Preconditions.checkArgument(null != id, "BookProductService.getBookProductById id cannot be null");

        BookDetail bookDetail = bookDetailService.getBookDetailByBookId(id);

        return new BookProduct(id, bookDetail);

    }

}
