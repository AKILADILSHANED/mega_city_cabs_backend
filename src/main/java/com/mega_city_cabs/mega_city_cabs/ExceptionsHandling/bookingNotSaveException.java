package com.mega_city_cabs.mega_city_cabs.ExceptionsHandling;

public class bookingNotSaveException extends RuntimeException{
    public bookingNotSaveException(String message){
        super(message);
    }

}
