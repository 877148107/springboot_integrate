## SpringBoot����RabbitMQ���

------

### 1.��ϸ����˵����ַ��https://blog.csdn.net/WMY1230/article/details/104763030

### 2.RabbitMQ�Զ�����ԭ��

�Զ�������RabbitAutoConfiguration

1���Զ����������ӹ���ConnectionFactory

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

2��RabbitProperties��װ��RabbitMQ����������

```propertiesproper
spring.rabbitmq.host=192.168.0.113
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

3��RabbitTemplate��RabbitMQ���ͺͽ�����Ϣ

4�� AmqpAdmin��RabbitMQϵͳ��������������������������е�

5������SpringbootIntegrateRabbitmqApplicationTests