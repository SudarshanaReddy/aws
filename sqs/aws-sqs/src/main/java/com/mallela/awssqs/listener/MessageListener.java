package com.mallela.awssqs.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    @SqsListener(value = "sqs-learner")
    public void receive(String message) {
        System.out.println(message);
    }
}
