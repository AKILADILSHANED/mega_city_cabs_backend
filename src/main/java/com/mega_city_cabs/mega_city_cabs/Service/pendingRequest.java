package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.approveRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

public interface pendingRequest {
    public approveRequestDTO approveRequest(String customerId);
    public approveRequestDTO rejectRequest(String customerId);
}
