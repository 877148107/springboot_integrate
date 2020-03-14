## SpringBoot整合ElasticSearch

### 1.详细整合说明地址：https://blog.csdn.net/WMY1230/article/details/104827455


## 1、ES的自动配置

SpringBoot默认支持两种技术和ES进行交互，Jest和SpringBoot-data-elasticSearch

### 		1）、JestAutoConfiguration（默认不生效）

​			如需要Jest生效需要导入io.searchbox.client.JestClient的jar包

![image-20200313211457104](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200313211457104.png)

### 		2）、ElasticsearchAutoConfiguration

​			1.TransportClient需要配置节点信息clusterNodes和clusterName

![image-20200313211518634](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200313211518634.png)

### 		3）、ElasticsearchDataAutoConfiguration

​			会给容器中添加一个ElasticsearchTemplate来操作ES

![image-20200313211601801](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200313211601801.png)

![image-20200313211616319](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200313211616319.png)

### 		4）、ElasticsearchRepositoriesAutoConfiguration

​			启用了ElasticsearchRepository接口可以对ES进行操作，类似于JPA的接口编程一样。即编写一个ElasticsearchRepository的子接口就可以对es进行增删改查的操作

![image-20200313211631348](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200313211631348.png)

## 2、Jest怎么操作ES

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(JestClient.class)
@EnableConfigurationProperties(JestProperties.class)
@AutoConfigureAfter(GsonAutoConfiguration.class)
@Deprecated
public class JestAutoConfiguration {

   @Bean(destroyMethod = "shutdownClient")
   @ConditionalOnMissingBean
   public JestClient jestClient(JestProperties properties, ObjectProvider<Gson> gson,
         ObjectProvider<HttpClientConfigBuilderCustomizer> builderCustomizers) {
      JestClientFactory factory = new JestClientFactory();
      factory.setHttpClientConfig(createHttpClientConfig(properties, gson, builderCustomizers));
      return factory.getObject();
   }

   protected HttpClientConfig createHttpClientConfig(JestProperties properties, ObjectProvider<Gson> gson,
         ObjectProvider<HttpClientConfigBuilderCustomizer> builderCustomizers) {
      HttpClientConfig.Builder builder = new HttpClientConfig.Builder(properties.getUris());
      PropertyMapper map = PropertyMapper.get();
      map.from(properties::getUsername).whenHasText()
            .to((username) -> builder.defaultCredentials(username, properties.getPassword()));
      Proxy proxy = properties.getProxy();
      map.from(proxy::getHost).whenHasText().to((host) -> {
         Assert.notNull(proxy.getPort(), "Proxy port must not be null");
         builder.proxy(new HttpHost(host, proxy.getPort()));
      });
      map.from(gson::getIfUnique).whenNonNull().to(builder::gson);
      map.from(properties::isMultiThreaded).to(builder::multiThreaded);
      map.from(properties::getConnectionTimeout).whenNonNull().asInt(Duration::toMillis).to(builder::connTimeout);
      map.from(properties::getReadTimeout).whenNonNull().asInt(Duration::toMillis).to(builder::readTimeout);
      builderCustomizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
      return builder.build();
   }

}
```

### 	1）、引入jest的jar包

```xml
<dependency>
    <groupId>io.searchbox</groupId>
    <artifactId>jest</artifactId>
    <version>6.3.1</version>
    <type>pom</type>
</dependency>
```

### 	2)、配置属性

```java
@ConfigurationProperties(prefix = "spring.elasticsearch.jest")
public class JestProperties {

   /**
    * Comma-separated list of the Elasticsearch instances to use.
    */
   private List<String> uris = new ArrayList<>(Collections.singletonList("http://localhost:9200"));

   /**
    * Login username.
    */
   private String username;

   /**
    * Login password.
    */
   private String password;
```

### 	3）、给ES中索引保存一个文档

```java
@SpringBootTest
class SpringbootIntegrateElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    /**
     * 给ES中索引保存一个文档
     */
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
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
```

![image-20200314131921050](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200314131921050.png)

### 4）、搜索ES

```java
@SpringBootTest
class SpringbootIntegrateElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

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
 }
```

![image-20200314134018474](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200314134018474.png)

## 3、SpringData操作ES

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency>
```

### 1）、配置属性

```properties
#Springdata操作es配置
spring.data.elasticsearch.cluster-nodes=192.168.0.113:9300
#这里可以不用设置默认elasticsearch
spring.data.elasticsearch.cluster-name=elasticsearch
```

### 2）、SpringBoot整合的ES的版本要和docker的ES镜像版本匹配

1.升级SpringBoot版本或者安装对应的elasticSearch

https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#reference

|                  Spring Data Release Train                   |                  Spring Data Elasticsearch                   | Elasticsearch |                         Spring Boot                          |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :-----------: | :----------------------------------------------------------: |
|                            Moore                             |                            3.2.x                             |     6.8.4     |                            2.2.x                             |
|                           Lovelace                           |                            3.1.x                             |     6.2.2     |                            2.1.x                             |
| Kay[[1](https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#_footnotedef_1)] | 3.0.x[[1](https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#_footnotedef_1)] |     5.5.0     | 2.0.x[[1](https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#_footnotedef_1)] |
| Ingalls[[1](https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#_footnotedef_1)] | 2.1.x[[1](https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#_footnotedef_1)] |     2.4.0     | 1.5.x[[1](https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#_footnotedef_1)] |

### 3）、ElasticsearchRepository子接口

```java
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findBookByBookNameLike(String bookName);
}
```

### 4）、需要标注索引和类型

```java
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
```

### 5）、添加索引文档

```java
@SpringBootTest
class SpringbootIntegrateElasticsearchApplicationTests {
    /**
     * ElasticsearchRepository子接口
     */
    @Autowired
    BookRepository bookRepository;

    /**
     * 使用ElasticsearchRepository子接口操作es
     */
    @Test
    public void testEs01(){
        Book book = new Book();
        book.setId(3);
        book.setBookName("水浒传");
        book.setAuthor("施耐庵");

        bookRepository.index(book);
    }
```

![image-20200314155621638](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200314155621638.png)

### 6）、自定义接口方法查询ES索引

更多方法命名规则：https://docs.spring.io/spring-data/elasticsearch/docs/3.2.5.RELEASE/reference/html/#elasticsearch.repositories

```java
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
```

![image-20200314160419771](C:\Users\a\AppData\Roaming\Typora\typora-user-images\image-20200314160419771.png)

### 7）、执行异常

docker启动es后9300访问不到es容器并且报错：

```java
NoNodeAvailableException[None of the configured nodes are available: [{#transport#-1}{PfqWva2-TWuAF-bmcr1jRg}{192.168.0.113}{192.168.0.113:9300}]
]
	at org.elasticsearch.client.transport.TransportClientNodesService.ensureNodesAreAvailable(TransportClientNodesService.java:352)
	at org.elasticsearch.client.transport.TransportClientNodesService.execute(TransportClientNodesService.java:248)
	at org.elasticsearch.client.transport.TransportProxyClient.execute(TransportProxyClient.java:60)
	at org.elasticsearch.client.transport.TransportClient.doExecute(TransportClient.java:388)
	at org.elasticsearch.client.support.AbstractClient.execute(AbstractClient.java:403)
	at org.elasticsearch.client.support.AbstractClient.execute(AbstractClient.java:391)
	at org.elasticsearch.action.ActionRequestBuilder.execute(ActionRequestBuilder.java:46)
	at org.springframework.data.elasticsearch.core.ElasticsearchTemplate.index(ElasticsearchTemplate.java:589)
	at 
```

解决方案：

1.进入es容器

```bash
[root@localhost ~]# docker exec -it 1fb31461934c /bin/bash
```

2.由于容器内不允许编辑所以要将文件拷贝出来

```bash
[root@localhost ~]# docker cp 1fb31461934c:/usr/share/elasticsearch/config/elasticsearch.yml /usr/share/elasticsearch.yml
```

3.拷贝完成后停止并删除原来启动的容器

4.修改/usr/share/elasticsearch.yml 将transport.host:0.0.0.0前的#去掉后保 存文件退出。其作用是允许任何ip地址访问elasticsearch .开发测试阶段可以这么做，生 产环境下指定具体的IP。

这里ES5.x版本和6.X版本不同，6.x版本里面没有transport.host:0.0.0.0  自己添加即可

5.然后启动容器

将外部的配置文件映射到容器里面的配置文件

```bash
[root@localhost ~]# docker run -d -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -p 9200:9200 -p 9300:9300 --name es01 -v /usr/share/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml  5acf0e
8da90b
```

