package com.krafttecnologies.tests.day23_Regex;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_2_PasswordControl {
    static boolean control;
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            passwordConrol(generateRandomPassword3());
            if (control){
                System.out.println(generateRandomPassword3());
                control=false;
            }
        }
    }
    public static void passwordConrol(String password){
        String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        //String regex2 = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d\\p{Punct}]{8,16}$";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Password is  valid..");
        } else {
            control=true;
            System.out.println("Password is not valid..");
        }

    }
    public static String generateRandomPassword2() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 8 + random.nextInt(9); // 8 ile 16 arasında bir sayı üret
        for (int i = 0; i < length; i++) {
            int type = random.nextInt(3);
            char c;
            if (type == 0) { // Büyük harf
                c = (char) (random.nextInt(26) + 'A');
            } else if (type == 1) { // Küçük harf
                c = (char) (random.nextInt(26) + 'a');
            } else { // Sayı
                c = (char) (random.nextInt(10) + '0');
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public static String generateRandomPassword() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String punctuation = "!@#$%^&*()_+-=[]{};:'\"<>,.?/\\|"; // Noktalama işaretleri
        int length = 8 + random.nextInt(9); // 8 ile 16 arasında bir sayı üret
        for (int i = 0; i < length; i++) {
            int type = random.nextInt(4);
            char c;
            if (type == 0) { // Büyük harf

                c = (char) (random.nextInt(26) + 'A');
            } else if (type == 1) { // Küçük harf
                c = (char) (random.nextInt(26) + 'a');
            } else if (type == 2) { // Sayı
                c = (char) (random.nextInt(10) + '0');
            } else { // Noktalama işareti
                c = punctuation.charAt(random.nextInt(punctuation.length()));
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public static String generateRandomPassword3(){
        Random rand = new Random();
        int length = rand.nextInt(9) + 8;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int ascii = rand.nextInt(75) + 48;
            char c;
            if (ascii >= 48 && ascii <= 57) {
                c = (char) ascii;
            } else if (ascii >= 65 && ascii <= 90) {
                c = (char) ascii;
            } else if (ascii >= 97 && ascii <= 122) {
                c = (char) ascii;
            } else {
                continue;
            }
            stringBuilder.append(c);
        }
        String s = stringBuilder.toString();
        return s;

    }

}
