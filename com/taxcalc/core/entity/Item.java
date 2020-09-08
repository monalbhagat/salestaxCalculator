package com.taxcalc.core.entity;

import java.text.DecimalFormat;
import java.util.stream.Stream;
import com.taxcalc.util.MathUtils;

public class Item {

    private String name;
    private int quantity;
    private double basePrice;
    private double basicSalesTaxAmount;
    private double additionalSalesTaxAmount;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public Item(String quantity, String name, String basePrice) {
        
    	this.quantity = Integer.valueOf(quantity);
        this.name = name;
        this.basePrice = Double.valueOf(basePrice);
    }

    public double getFinalPrice() {
        return MathUtils.roundOffAmount(quantity * basePrice + getTaxAmount());
    }

    public double getTaxAmount() {
        return quantity * (basicSalesTaxAmount + additionalSalesTaxAmount);
    }

    public boolean isImported() {
        return name.contains("imported");
    }

    public boolean isExempted() {
        return Stream.of("book", "chocolate","food", "pill","capsule")
                .anyMatch(exemptedItem -> name.contains(exemptedItem));
    }

    public void setBasicSalesTaxAmount(double factor) {
        basicSalesTaxAmount = basePrice * factor;
    }

    public void setAdditionalSalesTax(double additionalSalesTaxPercent) {
        additionalSalesTaxAmount = MathUtils.roundOffTax(basePrice * additionalSalesTaxPercent);
    }

    public String toString() {
        return String.valueOf(quantity) +
                " " +
                name +
                " : " +
                df.format(getFinalPrice());
    }
}
