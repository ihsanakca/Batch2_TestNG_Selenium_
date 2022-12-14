package com.krafttecnologies.tests.day14_PropertiesAndSingleton;

public class Singleton {
    //singleton class will have private constructor
    // it means other classes can NOT create an object of this class


    private Singleton() {
    }

    private static String str;

    public static String getInstance(){
        if (str==null){
            System.out.println("str is null, assign a value to it");
            str="chrome";
        }else {
            System.out.println("it has value, just returning it");
        }
        return str;
    }
}
