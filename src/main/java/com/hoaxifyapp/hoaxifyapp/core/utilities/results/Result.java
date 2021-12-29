package com.hoaxifyapp.hoaxifyapp.core.utilities.results;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;


public class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
