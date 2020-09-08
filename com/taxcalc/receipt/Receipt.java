package com.taxcalc.receipt;

import java.util.List;

import com.taxcalc.core.entity.Item;
import com.taxcalc.util.MathUtils;
import java.text.DecimalFormat;

public class Receipt {
    private double totalSalesTax = 0.0;
    private double totalAmount = 0.0;
    private String itemDetails;
    private static int count = 0;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public Receipt(List<Item> items) {

        StringBuilder itemDetails = new StringBuilder();

        for (Item item : items) {
            itemDetails.append(item.toString()).append("\n");
            totalSalesTax += item.getTaxAmount();
            totalAmount += item.getFinalPrice();
        }
        totalAmount = MathUtils.roundOffAmount(totalAmount);
        totalSalesTax = MathUtils.roundOffAmount(totalSalesTax);

        this.itemDetails = itemDetails.toString();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    @Override
    public String toString() {
        return  "Output " +(count+=1)+ ":\n"
                + itemDetails
                + "Sales Taxes : " + df.format(totalSalesTax) + "\n"
                + "Total : " + df.format(totalAmount)+"\n";
    }
}
