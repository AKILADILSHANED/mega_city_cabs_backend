package com.mega_city_cabs.mega_city_cabs.ExceptionsHandling;

public class customerNotFoundException extends RuntimeException{
    public customerNotFoundException (String message){
        super(message);
    }
}
