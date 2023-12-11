package com.mallela.awssqs.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSender {

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

 /*   @Autowired
    public MessageSender(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }*/

    @GetMapping(path="/send/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        Message<String> buildMessage = MessageBuilder.withPayload(message)
                .setHeader("sender", "mallela")
                .build();

        this.queueMessagingTemplate.send(endPoint, buildMessage);
    }
}
