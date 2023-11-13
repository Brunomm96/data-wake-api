package br.com.datawake.datawakeapi.exceptionhandler.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private HttpStatus status;
    private final String userMessage;

    public ApiException(HttpStatus status, String error, String userMessage) {
        super(error);
        this.status = status;
        this.userMessage = userMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
