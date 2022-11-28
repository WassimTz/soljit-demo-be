package com.soljit.touzene.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponseExtended<T> extends GenericResponse  {
    private T result ;

    public GenericResponseExtended(T objects ){
        super(GenericResponse.SUCCESS, 0);
        this.result = objects;
    }

    public GenericResponseExtended(String message, int code ){
        super(message, code);
    }

    public GenericResponseExtended(int code, String message , T objects){
        super(message, code);
        this.result = objects;
    }
}
