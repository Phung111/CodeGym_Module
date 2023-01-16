package utils;

import java.util.regex.Pattern;

public class ValidateUtils {

    public static final String LONGNUMBER_PATTERN = "^[0-9][0-9]*$";

    public static boolean isLongNumber(String number) {
        return Pattern.matches(LONGNUMBER_PATTERN, number);
    }
}
