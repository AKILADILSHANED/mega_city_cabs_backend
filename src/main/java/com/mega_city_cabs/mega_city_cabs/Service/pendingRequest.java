package com.mega_city_cabs.mega_city_cabs.Service;

import com.mega_city_cabs.mega_city_cabs.DTO.approveRequestDTO;

public interface pendingRequest {
    public approveRequestDTO approveRequest(String customerId);
    public approveRequestDTO rejectRequest(String customerId);
}
