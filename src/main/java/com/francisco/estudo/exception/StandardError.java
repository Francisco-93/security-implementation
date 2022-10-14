package com.francisco.estudo.exception;

import java.time.LocalDateTime;

public class StandardError {

    private String status;
    private LocalDateTime localDateTime;
    private String path;
    private String message;

    public StandardError(String status, LocalDateTime localDateTime, String path, String message) {
        this.status = status;
        this.localDateTime = localDateTime;
        this.path = path;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
