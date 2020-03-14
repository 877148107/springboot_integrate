package com.wmy.integrate.model;

import io.searchbox.annotations.JestId;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName: Book
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/13 21:30
 * @Version: V1.0
 */
@Document(indexName = "es",type = "book")
public class Book {

    @JestId//表示是一个主键
    private Integer id;

    private String bookName;

    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
