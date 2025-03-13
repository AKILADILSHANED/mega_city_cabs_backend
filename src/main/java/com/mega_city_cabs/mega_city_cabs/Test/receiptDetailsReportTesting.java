package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.receiptReportDTO;
import com.mega_city_cabs.mega_city_cabs.Service.reportIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class receiptDetailsReportTesting {
    @Autowired
    reportIMPL receiptDetailsTest;
    public void receiptDetails(){
        List<receiptReportDTO> receiptReport = receiptDetailsTest.getReceiptReport();
        for(receiptReportDTO reportObject: receiptReport){
            System.out.println(
                    "Receipt No: " + reportObject.getReceiptNumber() +
                            " Receipt Date: " + reportObject.getReceiptDate() +
                            " Payment Type: " + reportObject.getPaymentType() +
                            " Fare: " + reportObject.getFare() +
                            " Tax Rate: " + reportObject.getTaxRate()

            );
        }
    }
}
