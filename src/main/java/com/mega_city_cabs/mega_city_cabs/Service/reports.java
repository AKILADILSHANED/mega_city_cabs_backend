package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.Controller.customer;
import com.mega_city_cabs.mega_city_cabs.DTO.bookingDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.customerDTO;

import java.util.List;

public interface reports {
    public List<customerDTO> getCustomerReport();
    public List<bookingDTO> getBookingReport();
}
