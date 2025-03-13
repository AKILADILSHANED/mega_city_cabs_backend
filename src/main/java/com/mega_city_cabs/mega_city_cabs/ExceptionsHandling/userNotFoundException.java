package com.mega_city_cabs.mega_city_cabs.ExceptionsHandling;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException(String message){
        super(message);
    }
}
