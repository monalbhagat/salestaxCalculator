package com.taxcalc.app;

import com.taxcalc.core.entity.Item;
import com.taxcalc.core.factory.ItemFactory;
import com.taxcalc.receipt.Receipt;

import java.util.List;

public class ReceiptGenerator {

    public Receipt generateReceipt(String[] inputs) {
        List<Item> items = ItemFactory.from(inputs);
        return new Receipt(items);
    }
}
