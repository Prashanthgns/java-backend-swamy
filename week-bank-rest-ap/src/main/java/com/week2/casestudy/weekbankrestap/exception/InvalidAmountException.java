package com.week2.casestudy.weekbankrestap.exception;
// I have given an example of checking amount
// you need create all possible exceptions in a same way
public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(message);
    }
}
