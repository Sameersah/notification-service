package com.bytecraft.notificationservice.controller;

import com.bytecraft.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification")
    @ResponseBody
    public String sendNotification(@RequestBody String message) {
        return notificationService.sendNotification(message);
    }
}
