package com.taxcalc.core.factory;

import com.taxcalc.core.ItemAdapter;
import com.taxcalc.core.ItemTaxCalculator;
import com.taxcalc.core.entity.Item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemFactory {

    public static List<Item> from(String[] inputs) {
        return Arrays.stream(inputs)
                .map(ItemFactory::from)
                .collect(Collectors.toList());
    }

    private static Item from(String input) {
        Item item = ItemAdapter.createItemFromString(input);
        ItemTaxCalculator.applyTaxes(item);
        return item;
    }

}
