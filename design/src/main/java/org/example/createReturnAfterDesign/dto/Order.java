package org.example.createReturnAfterDesign.dto;

import java.time.LocalDateTime;

public class Order {
    public Long id;
    public String status;
    public LocalDateTime dateCreated;

    public Order(Long id, String status, LocalDateTime dateCreated) {
        this.id = id;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
