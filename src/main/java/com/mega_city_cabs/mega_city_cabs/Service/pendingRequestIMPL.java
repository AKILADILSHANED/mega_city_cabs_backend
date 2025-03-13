package com.mega_city_cabs.mega_city_cabs.Service;
import com.mega_city_cabs.mega_city_cabs.DTO.approveRequestDTO;
import com.mega_city_cabs.mega_city_cabs.Repository.pendingRequestRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class pendingRequestIMPL implements pendingRequest{
    @Autowired
    pendingRequestRepo pendingRequest;
    @Transactional
    @Override
    public approveRequestDTO approveRequest(String customerId) {
        approveRequestDTO requestDTO = new approveRequestDTO();
        try{
            int affectedRows = pendingRequest.approveRequest(
                    LocalDateTime.now(),
                    customerId
            );
            if(affectedRows > 0){
                requestDTO.setCustomerId(customerId);
                requestDTO.setApproveCode(1);
                requestDTO.setApproveMessage("Customer ID: " + customerId +  " approved successfully!");
                return requestDTO;
            }else{
                requestDTO.setCustomerId(customerId);
                requestDTO.setApproveCode(0);
                requestDTO.setApproveMessage(customerId +  "Unable to approve registration this time. Please contact administrator!");
                return requestDTO;
            }
        }catch (Exception e){
            requestDTO.setCustomerId(customerId);
            requestDTO.setApproveCode(0);
            requestDTO.setApproveMessage(customerId +  "An error occurred while approving the customer. Please try again later!");
            return requestDTO;
        }
    }
    @Transactional
    @Override
    public approveRequestDTO rejectRequest(String customerId) {
        approveRequestDTO requestDTO = new approveRequestDTO();
        try{
            int affectedRows = pendingRequest.rejectRequest(
                    LocalDateTime.now(),
                    customerId
            );
            if(affectedRows > 0){
                requestDTO.setCustomerId(customerId);
                requestDTO.setApproveCode(2);
                requestDTO.setApproveMessage("Customer ID: " + customerId +  " rejected successfully!");
                return requestDTO;
            }else{
                requestDTO.setCustomerId(customerId);
                requestDTO.setApproveCode(0);
                requestDTO.setApproveMessage(customerId +  "Unable to reject registration this time. Please contact administrator!");
                return requestDTO;
            }
        }catch (Exception e){
            requestDTO.setCustomerId(customerId);
            requestDTO.setApproveCode(0);
            requestDTO.setApproveMessage(customerId +  "An error occurred while rejecting the customer. Please try again later!");
            return requestDTO;
        }
    }
}
