package com.mega_city_cabs.mega_city_cabs.ExceptionsHandling;

public class bookingNotFoundException extends RuntimeException{
    public bookingNotFoundException(String message){
        super(message);
    }
}
