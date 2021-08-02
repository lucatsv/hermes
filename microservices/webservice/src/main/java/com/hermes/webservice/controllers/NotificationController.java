package com.hermes.webservice.controllers;

import com.hermes.webservice.models.Notification;
import com.hermes.webservice.models.jwt.JWTRequest;
import com.hermes.webservice.models.jwt.JWTResponse;
import com.hermes.webservice.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;


    @PostMapping("notification")
    public String CreateNotification(@RequestBody Notification notification) {
       return notificationService.createNotification(notification);
    }

    @GetMapping("notification/{id}")
    public Notification GetNotification(@PathVariable String id) {
        System.out.println("UUID: " + id);
        Notification notification = notificationService.findNotification(id);
        return notification;
    }

    @GetMapping("notifications")
    public List<Notification> GetAllNotifications(){
        return notificationService.getAllNotifications();
    }

    @DeleteMapping("notification/{id}")
    public void DeleteNotification(@PathVariable String id) {
        notificationService.deleteNotification(id);
    }

}
