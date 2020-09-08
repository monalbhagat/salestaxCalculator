package com.taxcalc.test;

import com.taxcalc.receipt.Receipt;
import com.taxcalc.app.ReceiptGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxCalcAppJunitTest {

    private ReceiptGenerator receiptGenerator = new ReceiptGenerator();

    @Test
    void test() {

        String[] inputs = {"1 book at 12.49", "1 music CD at 14.99",
                "1 chocolate bar at 0.85"};

        Receipt receipt = receiptGenerator.generateReceipt(inputs);

        System.out.println(receipt);
        Assertions.assertEquals(1.50, receipt.getTotalSalesTax());
        Assertions.assertEquals(29.83, receipt.getTotalAmount());

    }

    @Test
    void test2() {

        String[] inputs = {"1 imported box of chocolates at 10.00",
                "1 imported bottle of perfume at 47.50"};

        Receipt receipt = receiptGenerator.generateReceipt(inputs);
        System.out.println(receipt);
        Assertions.assertEquals(7.65, receipt.getTotalSalesTax());
        Assertions.assertEquals(65.15, receipt.getTotalAmount());
    }


    @Test
    void test3() {

        String[] inputs = {"1 imported bottle of perfume at 27.99",
                "1 food packet at 18.99",
                "1 packet of headache capsule at 9.75",
                "1 box of imported chocolate items at 11.25"};

        Receipt receipt = receiptGenerator.generateReceipt(inputs);
        System.out.println(receipt);
        Assertions.assertEquals(4.80, receipt.getTotalSalesTax());
        Assertions.assertEquals(72.78, receipt.getTotalAmount());

    }
}
