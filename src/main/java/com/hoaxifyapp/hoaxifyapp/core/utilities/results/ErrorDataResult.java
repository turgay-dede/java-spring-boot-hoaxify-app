package com.hoaxifyapp.hoaxifyapp.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(String message, T data) {
        super(false, data, message);
    }

    public ErrorDataResult(T data) {
        super(false, data);
    }

    public ErrorDataResult(String message) {
        super(false, null, message);
    }

    public ErrorDataResult() {
        super(false, null);
    }
}
