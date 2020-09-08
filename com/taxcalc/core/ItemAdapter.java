package com.taxcalc.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.taxcalc.core.entity.Item;

public class ItemAdapter {
    private static final String CHECK_REGEX = "(\\d+) ([\\w\\s]* )at (\\d+.\\d{2})";

    public static Item createItemFromString(String input) {
        Pattern pattern = Pattern.compile(CHECK_REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        return new Item(matcher.group(1), matcher.group(2), matcher.group(3));
    }
}
