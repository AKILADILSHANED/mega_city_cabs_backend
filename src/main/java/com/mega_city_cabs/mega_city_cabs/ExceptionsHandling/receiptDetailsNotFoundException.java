package com.mega_city_cabs.mega_city_cabs.ExceptionsHandling;

public class receiptDetailsNotFoundException extends RuntimeException{
    public receiptDetailsNotFoundException(String message){
        super(message);
    }
}
