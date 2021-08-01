package com.hermes.webservice.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class NotificationList {


    @Id
    private String id;
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    private String description;
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    private List<String> recipientsIds;
    public List<String> getRecipientsIds() {
        return recipientsIds;
    }
    public void setRecipients(List<String> recipientsIds) {
        this.recipientsIds = recipientsIds;
    }

    private List<String> notificationsIds;
    public void setNotifications(List<String> notificationsIds) {
        this.notificationsIds = notificationsIds;
    }
    public List<String> getNotifications() {
        return this.notificationsIds;
    }
}
