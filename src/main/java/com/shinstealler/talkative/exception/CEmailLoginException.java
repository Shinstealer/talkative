package com.shinstealler.talkative.exception;

public class CEmailLoginException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -1367845691L;

    public CEmailLoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public CEmailLoginException(String msg) {
        super(msg);
    }

    public CEmailLoginException() {
        super();
    }

}