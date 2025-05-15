package coop.confiar.utilities.helpers;

import java.util.regex.Pattern;

public abstract class RegexHelper {
    public static final String EMAIL_PATTERN = ("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    public static final String NUMBER_PATTERN = ("^-?\\d+(\\.\\d+)?$");
    public static final String LETTERS_WITH_ACCENTS_PATTERN = ("^[\\p{L}ñÑáéíóúÁÉÍÓÚüÜ\\s]+$");
    public static final String ALPHANUMERIC_WITH_ACCENTS_PATTERN = ("^[\\p{L}\\p{N}ñÑáéíóúÁÉÍÓÚüÜ\\s]+$");
    public static final String ALPHANUMERIC_WITH_ACCENTS_SPECIAL_PATTERN = ("^[\\p{L}\\p{N}\\p{P}\\p{S}\\s]+$");
    public static final String PASSWORD_PATTERN = ("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}:;\"',.<>?]).{8,}$");
    public static final String UUID_PATTERN = ("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$");
    public static final String BOOLEAN_PATTERN = ("^(?i)(true|false)$");
    public static final String VALID_ID_PATTERN = ("^[1-9]\\d*$");

    public static boolean isEmail(String input) {
        return matches(input, Pattern.compile(EMAIL_PATTERN));
    }

    public static boolean isNumber(String input) {
        return matches(input, Pattern.compile(NUMBER_PATTERN));
    }

    public static boolean isLettersWithAccents(String input) {
        return matches(input, Pattern.compile(LETTERS_WITH_ACCENTS_PATTERN));
    }

    public static boolean isAlphanumericWithAccents(String input) {
        return matches(input, Pattern.compile(ALPHANUMERIC_WITH_ACCENTS_PATTERN));
    }

    public static boolean isAlphanumericWithAccentsAndSpecialChars(String input) {
        return matches(input, Pattern.compile(ALPHANUMERIC_WITH_ACCENTS_SPECIAL_PATTERN));
    }

    public static boolean isValidPassword(String input) {
        return matches(input, Pattern.compile(PASSWORD_PATTERN));
    }

    public static boolean isUUID(String input) {
        return matches(input, Pattern.compile(UUID_PATTERN));
    }

    public static boolean isBoolean(String input) {
        return matches(input, Pattern.compile(BOOLEAN_PATTERN));
    }

    public static boolean isValidId(String input) {
        return matches(input, Pattern.compile(VALID_ID_PATTERN)) || isUUID(input);
    }

    private static boolean matches(String input, Pattern pattern) {
        return input != null && pattern.matcher(input).matches();
    }
}