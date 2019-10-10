package com.springboot.bookinfo.details.service.impl;

import com.springboot.bookinfo.details.BookDetail;
import com.springboot.bookinfo.details.lib.detail.BookDetailProto;
import com.springboot.bookinfo.details.lib.detail.BookDetailProto.GetBookDetailRequest;
import com.springboot.bookinfo.details.lib.detail.BookDetailServiceGrpc;
import com.springboot.bookinfo.details.service.BookDetailService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * 类GrpcBookDetailService的实现描述: GrpcBookDetailService
 *
 * @author hongyang 2019-10-09 19:46
 */
@Service
public class GrpcBookDetailService implements BookDetailService {

    @GrpcClient("detail")
    private BookDetailServiceGrpc.BookDetailServiceBlockingStub bookDetailServiceStub;

    @Override
    public BookDetail getBookDetailByBookId(Long bookId) {

        GetBookDetailRequest bookDetailRequest = GetBookDetailRequest.newBuilder().setProductId(bookId).build();
        BookDetailProto.BookDetail bookDetail = bookDetailServiceStub.getBookDetail(bookDetailRequest);

        return new BookDetail(
                bookDetail.getId(),
                bookDetail.getAuthor(),
                bookDetail.getYear(),
                bookDetail.getType(),
                bookDetail.getPages(),
                bookDetail.getPublisher(),
                bookDetail.getLanguage(),
                bookDetail.getIsbn10(),
                bookDetail.getIsbn13());
    }
}
