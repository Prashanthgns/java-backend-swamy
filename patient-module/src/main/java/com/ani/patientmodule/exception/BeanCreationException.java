package com.ani.patientmodule.exception;

import org.springframework.beans.FatalBeanException;

public class BeanCreationException extends FatalBeanException {
    public BeanCreationException(boolean message) {
        super(String.valueOf(message));
    }
}
