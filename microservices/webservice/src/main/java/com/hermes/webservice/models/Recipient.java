package com.hermes.webservice.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recipient {

    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return this.lastName;
    }
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    private String phone;
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    private Boolean enablePhoneNotification;
    public Boolean getEnablePhoneNotification() {
        return enablePhoneNotification;
    }
    public void setEnablePhoneNotification(Boolean enablePhoneNotification) {
        this.enablePhoneNotification = enablePhoneNotification;
    }

    private Boolean enableEmailNotification;
    public Boolean getEnableEmailNotification() {
        return  this.enableEmailNotification;
    }
    public void setEnableEmailNotification(Boolean enableEmailNotification) {
        this.enableEmailNotification = enableEmailNotification;
    }
}
