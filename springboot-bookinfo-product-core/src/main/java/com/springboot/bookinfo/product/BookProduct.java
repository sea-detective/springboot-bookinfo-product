package com.springboot.bookinfo.product;

import com.springboot.bookinfo.details.BookDetail;

/**
 * 类BookProduct的实现描述: BookProduct
 *
 * @author hongyang 2019-10-08 20:22
 */
public class BookProduct {

    private Long id;

    private BookDetail bookDetail;

    public BookProduct(Long id, BookDetail bookDetail) {
        this.id = id;
        this.bookDetail = bookDetail;
    }

    public Long getId() {
        return id;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }
}
