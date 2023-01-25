package com.krafttecnologies.tests.day23_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordControlWithRegex {

    public static void main(String[] args) {
        passwordControl("2d113+%'^+%&/4A");

    }
    public static void passwordControl(String password){
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        String regex2 = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d\\p{Punct}]{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Password is  valid..");
        } else {
            System.out.println("Password is not valid..");
        }
    }
}
