package com.hermes.webservice.models;


import com.hermes.webservice.enums.Periodicity;

import java.time.LocalDateTime;

public class Schedule {

    private LocalDateTime startDate;
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    private LocalDateTime endDate;
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Periodicity periodicity;

}