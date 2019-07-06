package com.example.homework.exception;

public class AddressNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5857446616273616191L;

    public AddressNotFoundException(String msg){
        super(msg);
    }

}
