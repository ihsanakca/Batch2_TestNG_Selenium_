package com.krafttecnologies.tests.day25_JWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.testng.annotations.Test;

public class JWT_Generate {

    @Test
    public void test1(){
        String secretKey = "secret";
        String jwt = Jwts.builder()
                .setSubject("user")
                .setIssuer("your_app")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        System.out.println("jwt = " + jwt);
    }
}
