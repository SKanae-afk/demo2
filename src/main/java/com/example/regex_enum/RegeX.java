package com.example.regex_enum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegeX {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]", Pattern.CASE_INSENSITIVE);

    public static boolean checkbox(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}