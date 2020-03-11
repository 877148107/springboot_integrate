## SpringBoot整合RabbitMQ框架

------

### 1.详细整合说明地址：https://blog.csdn.net/WMY1230/article/details/104763030

### 2.RabbitMQ自动配置原理

自动配置类RabbitAutoConfiguration

1、自动配置了链接工厂ConnectionFactory

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ RabbitTemplate.class, Channel.class })
@EnableConfigurationProperties(RabbitProperties.class)
@Import(RabbitAnnotationDrivenConfiguration.class)
public class RabbitAutoConfiguration {

	@Configuration(proxyBeanMethods = false)
	@ConditionalOnMissingBean(ConnectionFactory.class)
	protected static class RabbitConnectionFactoryCreator {

		@Bean
		public CachingConnectionFactory rabbitConnectionFactory(RabbitProperties properties,
				ObjectProvider<ConnectionNameStrategy> connectionNameStrategy) throws Exception {
			PropertyMapper map = PropertyMapper.get();
			CachingConnectionFactory factory = new CachingConnectionFactory(
					getRabbitConnectionFactoryBean(properties).getObject());
			map.from(properties::determineAddresses).to(factory::setAddresses);
			map.from(properties::isPublisherReturns).to(factory::setPublisherReturns);
			map.from(properties::getPublisherConfirmType).whenNonNull().to(factory::setPublisherConfirmType);
			RabbitProperties.Cache.Channel channel = properties.getCache().getChannel();
			map.from(channel::getSize).whenNonNull().to(factory::setChannelCacheSize);
			map.from(channel::getCheckoutTimeout).whenNonNull().as(Duration::toMillis)
					.to(factory::setChannelCheckoutTimeout);
			RabbitProperties.Cache.Connection connection = properties.getCache().getConnection();
			map.from(connection::getMode).whenNonNull().to(factory::setCacheMode);
			map.from(connection::getSize).whenNonNull().to(factory::setConnectionCacheSize);
			map.from(connectionNameStrategy::getIfUnique).whenNonNull().to(factory::setConnectionNameStrategy);
			return factory;
		}
```

2、RabbitProperties封装了RabbitMQ的所有配置

```propertiesproper
spring.rabbitmq.host=192.168.0.113
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

3、RabbitTemplate给RabbitMQ发送和接收消息

4、 AmqpAdmin：RabbitMQ系统管理功能组件，创建交换器、队列等

5、测试SpringbootIntegrateRabbitmqApplicationTests