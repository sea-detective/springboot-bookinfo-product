package com.springboot.bookinfo.details;

/**
 * 类BookDetail的实现描述: BookDetail
 *
 * @author hongyang 2019-10-08 20:13
 */
public class BookDetail {

    private Long bookId;
    private String author;
    private Integer year;
    private String type;
    private Integer pages;
    private String publisher;
    private String language;
    private String isbn10;
    private String isbn13;

    public BookDetail(Long bookId,
                      String author,
                      Integer year,
                      String type,
                      Integer pages,
                      String publisher,
                      String language,
                      String isbn10,
                      String isbn13) {
        this.bookId = bookId;
        this.author = author;
        this.year = year;
        this.type = type;
        this.pages = pages;
        this.publisher = publisher;
        this.language = language;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public Integer getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }
}
