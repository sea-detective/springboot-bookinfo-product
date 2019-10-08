package com.springboot.bookinfo.details.service;

import com.springboot.bookinfo.details.BookDetail;

/**
 * 类BookDetailService的实现描述: BookDetailService
 *
 * @author hongyang 2019-10-08 20:14
 */
public interface BookDetailService {

    BookDetail getBookDetailByBookId(Long bookId);

}
