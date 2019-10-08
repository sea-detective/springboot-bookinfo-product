package com.springboot.bookinfo.details.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot.bookinfo.details.BookDetail;
import com.springboot.bookinfo.details.service.BookDetailService;
import com.springboot.bookinfo.product.infra.utils.RestTemplateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 类HttpBookDetailService的实现描述: Http方式来实现的BookDetail服务
 *
 * @author hongyang 2019-10-08 20:20
 */
@Service("bookDetailService")
public class HttpBookDetailService implements BookDetailService {

    private static final String GET_BOOK_DETAIL_BASE_URL = "http://details:7001/details/";

    @Override
    public BookDetail getBookDetailByBookId(Long bookId) {

        String bookDetailResult = RestTemplateUtils.postByForm(GET_BOOK_DETAIL_BASE_URL + bookId, null, String.class, 3);

        if (StringUtils.isNotBlank(bookDetailResult)) {

            JSONObject bookDetailJsonObj = JSONObject.parseObject(bookDetailResult);

            return new BookDetail(
                    bookDetailJsonObj.getLong("id"),
                    bookDetailJsonObj.getString("author"),
                    bookDetailJsonObj.getInteger("year"),
                    bookDetailJsonObj.getString("type"),
                    bookDetailJsonObj.getInteger("pages"),
                    bookDetailJsonObj.getString("publisher"),
                    bookDetailJsonObj.getString("language"),
                    bookDetailJsonObj.getString("isbn10"),
                    bookDetailJsonObj.getString("isbn13"));

        }

        return null;
    }
}
