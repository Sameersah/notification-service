package com.bytecraft.notificationservice.scheduler;

import com.bytecraft.notificationservice.enums.NotificationType;
import com.bytecraft.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {

    private static final Logger log = LoggerFactory.getLogger(NotificationScheduler.class);
    @Autowired
    NotificationService notificationService;

    @Scheduled(cron = "*/5 * * * * ?")
    public void sendEmailNotification() {
        String message = "This is a test email notification";
        String result = notificationService.sendNotification(message, NotificationType.EMAIL);
        log.info(result);

    }
}
