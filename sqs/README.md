## Simple Queue Service

- Distributed messaging service.
- ***Standard***


- ***Steps:***

  - First create the sqs - queue
  - Create user and add user to the sqs queue,this will give the access key, secret key and endpoint uri.
  - Next inorder to integrate with spring boot we need the following.
  
  ```
   <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-aws</artifactId>
			<version>2.2.6.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-aws-messaging</artifactId>
			<version>2.2.6.RELEASE</version>
		</dependency>
  ```
  
- Following config is needed.
  ```
   @Configuration
   public class SQSConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey,secretKey);

        return AmazonSQSAsyncClientBuilder
                .standard()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
  }
  ```

- Standard Queue Vs FIFO Queue
  - In case of FIFO, we need group id and deduplication id
  - ***TODO:*** Understand the difference between the two.
