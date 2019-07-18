package com.javajaxrs.conf.config;

public class ConfigNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1234567890L;

    public ConfigNotFoundException(String message) {
        super(message);
    }

    public ConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ConfigNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
