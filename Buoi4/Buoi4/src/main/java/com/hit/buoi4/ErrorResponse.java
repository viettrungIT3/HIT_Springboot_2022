package com.hit.buoi4;

public class ErrorResponse {

    private Integer status;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
