package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.DTO.receiptConfirmDTO;
import com.mega_city_cabs.mega_city_cabs.DTO.receiptDTO;
import com.mega_city_cabs.mega_city_cabs.Service.receiptIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class billIssueTesting {
    @Autowired
    receiptIMPL receiptIssueTesting;

    public String receiptIssueTesting(){
        receiptDTO receiptdto = new receiptDTO(
                "Cash",
                10.0,
                1500.0,
                "CUS0004",
                "BK00004"
        );
        return receiptIssueTesting.issueReceipt(receiptdto).getReceiptMessageCode();
    }

}
