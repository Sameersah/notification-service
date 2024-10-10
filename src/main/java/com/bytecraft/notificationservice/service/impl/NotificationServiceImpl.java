package com.bytecraft.notificationservice.service.impl;

import com.bytecraft.notificationservice.enums.NotificationType;
import com.bytecraft.notificationservice.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Override
    public String sendNotification(String message, NotificationType notificationType) {
        return switch (notificationType) {
            case EMAIL -> sendEmailNotification(message);
            case SMS -> sendSmsNotification(message);
            case PUSH -> sendPushNotification(message);
            default -> "Invalid notification type";
        };
    }

    private String sendEmailNotification(String message) {
        return "Email notification sent: " + message;
    }

    private String sendSmsNotification(String message) {
        return "SMS notification sent: " + message;
    }

    private String sendPushNotification(String message) {
        return "Push notification sent: " + message;
    }

    @Override
    public String sendNotification(String message) {
        return "";
    }

}
