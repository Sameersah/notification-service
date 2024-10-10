package com.bytecraft.notificationservice.service;

import com.bytecraft.notificationservice.enums.NotificationType;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    public String sendNotification(String message);

    public String sendNotification(String message, NotificationType notificationType);
}
