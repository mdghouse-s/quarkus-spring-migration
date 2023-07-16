package com.learn.rest.exception;

public class ContactExistException  extends RuntimeException{
        
            private static final long serialVersionUID = 1L;
        
            public ContactExistException(String message) {
                super(message);
            }
    
            public ContactExistException(String message, Throwable cause) {
                super(message, cause);
            }
}
