package com.springboot.bookinfo.details.service.impl;

import com.springboot.bookinfo.details.BookDetail;
import com.springboot.bookinfo.details.service.BookDetailService;
import org.springframework.stereotype.Service;

/**
 * 类HttpBookDetailService的实现描述: Http方式来实现的BookDetail服务
 *
 * @author hongyang 2019-10-08 20:20
 */
@Service
public class HttpBookDetailService implements BookDetailService {

    @Override
    public BookDetail getBookDetailByBookId(Long bookId) {
        return null;
    }
}
