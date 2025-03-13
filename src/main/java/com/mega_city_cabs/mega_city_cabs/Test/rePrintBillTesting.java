package com.mega_city_cabs.mega_city_cabs.Test;

import com.mega_city_cabs.mega_city_cabs.Service.receiptIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class rePrintBillTesting {
    @Autowired
    receiptIMPL receipt;

    public String rePrintBillTesting(){
        return receipt.receiptReprint("4541313").getReturnMessage();
    }
}
