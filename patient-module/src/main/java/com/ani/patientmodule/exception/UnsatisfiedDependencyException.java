package com.ani.patientmodule.exception;

import org.springframework.beans.factory.BeanCreationException;

public class UnsatisfiedDependencyException extends BeanCreationException{
    public UnsatisfiedDependencyException(String message) {
        super(message);
    }
}
