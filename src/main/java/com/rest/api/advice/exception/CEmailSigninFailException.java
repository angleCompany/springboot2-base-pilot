package com.rest.api.advice.exception;

public class CEmailSigninFailException extends RuntimeException {
    public CEmailSigninFailException(String msg, Throwable e) {
        super(msg, e);
    }

    public CEmailSigninFailException(String msg) {
        super(msg);
    }

    public CEmailSigninFailException() {
        super();
    }
}
