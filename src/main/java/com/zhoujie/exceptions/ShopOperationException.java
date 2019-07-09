package com.zhoujie.exceptions;

public class ShopOperationException extends RuntimeException {
    public ShopOperationException() {
    }

    public ShopOperationException(String message) {
        super(message);
    }

    public ShopOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopOperationException(Throwable cause) {
        super(cause);
    }

    public ShopOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
