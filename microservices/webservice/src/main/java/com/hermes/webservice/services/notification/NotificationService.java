package com.hermes.webservice.services.notification;

import com.hermes.webservice.models.Notification;

import java.util.List;


public interface NotificationService {

    public String createNotification(Notification notification);

    public Notification findNotification(String id);

    public List<Notification> getAllNotifications();

    public void deleteNotification(String id);
}
