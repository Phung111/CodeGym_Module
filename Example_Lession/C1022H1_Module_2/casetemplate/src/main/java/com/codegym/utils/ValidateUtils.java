package com.codegym.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String ADDRESS_PATTERN = "^[A-Za-z0-9][A-Za-z0-9\\s]{7,19}$";

    public static boolean isAddressValid(String address) {
        return Pattern.matches(ADDRESS_PATTERN, address);
    }
}
