package com.mega_city_cabs.mega_city_cabs.Controller;

import com.mega_city_cabs.mega_city_cabs.DTO.approveRequestDTO;
import com.mega_city_cabs.mega_city_cabs.Service.pendingRequestIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/pending-requests")
public class pendingRequest {

    @Autowired
    pendingRequestIMPL pendingRequest;

    @PutMapping("/approve-request")
    private approveRequestDTO approveRequest(@RequestParam String customerId){
        return pendingRequest.approveRequest(customerId);
    }

    @PutMapping("/reject-request")
    private approveRequestDTO rejectRequest(@RequestParam String customerId){
        return pendingRequest.rejectRequest(customerId);
    }
}
