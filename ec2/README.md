# ec2 and S3

- To deploy spring boot app on ec2 instance

  - create an ec2 instance
  - create a s3 bucket,this is needed to store the spring boot jar file.
`zAo90p=]
  - 
  e`1
- ***Connect to ec2 instance from terminal***
  ```
    ssh -i /path/key-pair-name.pem instance-user-name@instance-public-dns-name
    ssh -i mallela-ec2-keypair.pem ec2-user@ec2-3-91-248-221.compute-1.amazonaws.com  
  ``` 
- ***Set the permissions to the .pemfile***

  ```
   chmod 400 .pemfilename
  ```
- ***Install Java***
  ```
   yum install 
  ```
- ***Pull the spring boot jar into ec2 instance***

  ```
    wget https://s3-learner.s3.amazonaws.com/api-gateway-0.0.1-SNAPSHOT.jar
  ```  
- ***S3  bucket policy***

  ```
  {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": [
                "s3:GetObject",
                "s3:*"
            ],
            "Resource": "arn:aws:s3:::s3-learner/*"
        }
    ]
  }
  ```
  






