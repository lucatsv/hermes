package com.hermes.webservice.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notification {

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
        return  description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    private Date creationDate = new Date();
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    private String message;
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    private List<Recipient> recipients;
    public List<Recipient> getRecipients() {
        return recipients;
    }
    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    @JsonIgnore
    private List<String> recipientsIds;
    public List<String> getRecipientsIds() {
        return recipientsIds;
    }
    public void setRecipientsIds(List<String> recipientsIds) {
        this.recipientsIds = recipientsIds;
    }

    private Schedule schedule;
    public Schedule getSchedule() {
        return schedule;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    @Override
    public String toString(){
        return String.format("Description: %s\nMessage: %s",this.description, this.message);
    }

}
