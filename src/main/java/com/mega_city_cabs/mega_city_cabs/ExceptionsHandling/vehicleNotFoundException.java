package com.mega_city_cabs.mega_city_cabs.ExceptionsHandling;

public class vehicleNotFoundException extends RuntimeException{
    public vehicleNotFoundException(String message){
        super(message);
    }
}
