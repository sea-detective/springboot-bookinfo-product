package com.springboot.bookinfo.details.service.impl;

import com.springboot.bookinfo.details.BookDetail;
import com.springboot.bookinfo.details.service.BookDetailService;
import org.springframework.stereotype.Service;

/**
 * 类MockBookDetailService的实现描述: Mock版本的BookDetailService
 *
 * @author hongyang 2019-10-08 20:35
 */
@Service
public class MockBookDetailService implements BookDetailService {

    @Override
    public BookDetail getBookDetailByBookId(Long bookId) {

        return new BookDetail(bookId,
                "William Shakespeare",
                1595,
                "paperback",
                200,
                "PublisherA",
                "English",
                "1234567890",
                "123-1234567890");
    }
}
