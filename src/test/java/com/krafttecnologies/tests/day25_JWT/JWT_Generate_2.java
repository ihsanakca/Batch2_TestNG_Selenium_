package com.krafttecnologies.tests.day25_JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.testng.annotations.Test;

public class JWT_Generate_2 {

    @Test
    public void test1(){
        String secretKey = "secret";
        String jwt = JWT.create()
                .withSubject("user")
                .withIssuer("your_app")
                .sign(Algorithm.HMAC256(secretKey));

        System.out.println("jwt = " + jwt);
    }
}
