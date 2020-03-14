package com.wmy.integrate;

import com.wmy.integrate.model.Book;
import com.wmy.integrate.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringbootIntegrateElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    /**
     * ElasticsearchRepository子接口
     */
    @Autowired
    BookRepository bookRepository;

    /**
     * 使用自定方法查询
     */
    @Test
    public void testEs02(){
        List<Book> books = bookRepository.findBookByBookNameLike("水");
        books.stream().forEach(System.out::println);
    }

    /**
     * 使用ElasticsearchRepository子接口操作es
     */
    @Test
    public void testEs01(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("水月洞天");
        book.setAuthor("张三");

        bookRepository.index(book);
    }

    /**
     * 测试ES搜索
     */
    @Test
    public void searchEs(){
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"bookName\" : \"西游记\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //构建搜索功能
        Search build = new Search.Builder(json).addIndex("es").addType("book").build();

        //执行
        try {
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 给ES中索引保存一个文档
     */
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(2);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");

        //建立索引
        Index index = new Index.Builder(book).index("es").type("book").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
