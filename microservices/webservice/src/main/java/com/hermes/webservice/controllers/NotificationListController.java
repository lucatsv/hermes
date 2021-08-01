package com.hermes.webservice.controllers;

import com.hermes.webservice.models.NotificationList;
import com.hermes.webservice.services.notificationList.NotificationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationListController
{

    @Autowired
    public NotificationListService notificationListService;


    @GetMapping("/notificationsLists")
    public List<NotificationList> getAllNotificationsLists() {
        return notificationListService.getAllNotificationlist();
    }

    @GetMapping("/notificationList/{id}")
    public NotificationList getNotificationList(@PathVariable String id)
    {
        return notificationListService.findNotificationList(id);
    }

    @DeleteMapping("/notificationList/{id}")
    public void deleteNotificationList(@PathVariable String id)
    {
        notificationListService.deleteNotificationList(id);
    }

    @PostMapping("/notificationList")
    public String createNotificationList(@RequestBody NotificationList notificationList)
    {
        return notificationListService.createNotificationList(notificationList);
    }


}
