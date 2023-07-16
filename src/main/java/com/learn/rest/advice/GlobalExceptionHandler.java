package com.learn.rest.advice;



import com.learn.rest.exception.ContactExistException;
import com.learn.rest.exception.ContactNotFoundException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;




@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    /* handler for exceptions */
        @Override
    public Response toResponse(Exception e) {
        if (e instanceof ContactNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } else if (e instanceof ContactExistException) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
