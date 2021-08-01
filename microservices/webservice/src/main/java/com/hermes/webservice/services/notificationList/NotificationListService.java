package com.hermes.webservice.services.notificationList;

import com.hermes.webservice.models.NotificationList;

import java.util.List;

public interface NotificationListService {
    public String createNotificationList(NotificationList notificationList);

    public NotificationList findNotificationList(String id);

    public List<NotificationList> getAllNotificationlist();

    public void deleteNotificationList(String id);
}
