package com.wmy.integrate.repository;

import com.wmy.integrate.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @ClassName: BookRepository
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/3/14 14:04
 * @Version: V1.0
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findBookByBookNameLike(String bookName);
}
