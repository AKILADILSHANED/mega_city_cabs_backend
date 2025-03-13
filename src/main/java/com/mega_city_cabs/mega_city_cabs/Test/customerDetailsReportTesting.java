package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.customerDTO;
import com.mega_city_cabs.mega_city_cabs.Service.reportIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class customerDetailsReportTesting {
    @Autowired
    reportIMPL reportCustomerDetailsTesting;
    public void customerList(){
        List<customerDTO> reportCustomer = reportCustomerDetailsTesting.getCustomerReport();
        for(customerDTO customerObject: reportCustomer){
            System.out.println("Customer ID " + customerObject.getCustomerId() +
                    " First Name " + customerObject.getFirstName() +
                    " Last Name " + customerObject.getLastName() +
                    " Contact " + customerObject.getContact() +
                    " Email " + customerObject.getEmail() +
                    " NIC " + customerObject.getNic() +
                    " Address " + customerObject.getAddress()
            );
        }
    }
}
