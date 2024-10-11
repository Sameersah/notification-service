package com.bytecraft.notificationservice.scheduler;

import com.bytecraft.notificationservice.enums.NotificationType;
import com.bytecraft.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class NotificationScheduler {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(NotificationScheduler.class);
    @Autowired
    NotificationService notificationService;

    @Scheduled(cron = "0 */1 * * * ?")
    public void sendEmailNotification() {
        log.info("Cron Job reading messages from rabbitmq queue after 1 minute");
        Message message = rabbitTemplate.receive("queue-1");
        if(message != null){
            log.info("1 Message Received: {}", new String(message.getBody()));
            MessageProperties properties = message.getMessageProperties();
            log.info("message(s) Backlog/Remaining in the Queue to be processed: {}", properties.getMessageCount());
          //  String result = notificationService.sendNotification(new String(message.getBody()), NotificationType.EMAIL);
            //log.info(result);
        } else {
            log.info("All Messages processed, queue is empty");
        }


    }
}
