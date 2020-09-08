package com.taxcalc.core;

import com.taxcalc.core.entity.Item;

public class ItemTaxCalculator {
    private static final double SALES_TAX = 0.1;
    private static final double IMPORT_DUTY = 0.05;

    public static void applyTaxes(Item item) {
        if (!item.isExempted()) {
            item.setBasicSalesTaxAmount(SALES_TAX);
        }

        if (item.isImported()) {
            item.setAdditionalSalesTax(IMPORT_DUTY);
        }
    }
}
