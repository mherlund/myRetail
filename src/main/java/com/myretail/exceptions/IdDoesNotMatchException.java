package com.myretail.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class IdDoesNotMatchException extends RuntimeException {

    public IdDoesNotMatchException(){
        super();
    }

    public IdDoesNotMatchException(String message){
        super(message);
    }

}
