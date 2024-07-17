package com.example.userManagement.dto;

public class CheckInResponse {
    private String status;
    private String message;

    public CheckInResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

