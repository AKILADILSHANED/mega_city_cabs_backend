package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.receiptIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class deleteBillTesting {
    @Autowired
    receiptIMPL receiptDeleteTesting;
    public String receiptDeleteTesting(){
        return receiptDeleteTesting.deleteReceipt("RCPT00002");
    }
}
