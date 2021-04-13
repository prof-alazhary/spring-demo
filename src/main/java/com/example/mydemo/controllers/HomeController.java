package com.example.mydemo.controllers;

import com.naturalprogrammer.spring.lemon.jwtUtil.exptions.InvalidTokenException;
import com.naturalprogrammer.spring.lemon.jwtUtil.util.JWTUtil;
import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.security.Keys;
import java.security.Key;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HomeController {


    final Logger logger = LogManager.getLogger(HomeController.class);

    public HomeController(){
    }

    @Value("${app.version}")
    private String version;

//    @GetMapping
//    @RequestMapping("/")
//    public Jwt<Header, Claims> getStatus(HttpServletRequest request,@RequestHeader(name="Authorization") String token){
//        System.out.println("HttpServletRequest --->>>> " + request.getHeader("Authorization").toString());
//        String[] jwt_arr = token.split(" ");
//        String jwt_only = jwt_arr[1];
//        int i = jwt_only.lastIndexOf('.');
//        String withoutSignature = jwt_only.substring(0, i+1);
//        System.out.println("withoutSignature --->>>> " + withoutSignature.toString());
//
//        Jwt<Header, Claims> jwtObj = Jwts.parser().parseClaimsJwt(withoutSignature);
//
//        System.out.println("jwtObj --->>>> " + jwtObj.toString());
//        logger.info("jwtObj --->>>> " + jwtObj.toString());
//
//
//        return  jwtObj;
//    }

    @GetMapping
    @RequestMapping("/")
    public Map getStatus(HttpServletRequest request, HttpServletResponse response) throws InvalidTokenException {
        JWTUtil jwtUtil = new JWTUtil();
        System.out.println(jwtUtil.parseJWS("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyIsImtpZCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyJ9.eyJhdWQiOiIwMDAwMDAwMi0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8wZWFkNTg3ZC1kOGRhLTQ1ODUtYmMzNC1kYWUwZjliMmVmOTYvIiwiaWF0IjoxNjE4MDgxMTE2LCJuYmYiOjE2MTgwODExMTYsImV4cCI6MTYxODA4NTAxNiwiYWNyIjoiMSIsImFpbyI6IkUyWmdZTGhhcTZ0enJYdFJ3TkxQRzdzNWp4b2Q1elIrV1Z6MjJHQ0cyV2JQbDNMdEhNa0EiLCJhbXIiOlsicHdkIl0sImFwcGlkIjoiYTYwMTNhNTUtY2ExZi00Njk3LTg4MjctNzRiNzYwYzJhZjk0IiwiYXBwaWRhY3IiOiIxIiwiZmFtaWx5X25hbWUiOiJBYnUgdHJpa2EiLCJnaXZlbl9uYW1lIjoiTW9oYW1lZCIsImlwYWRkciI6IjE1Ni4xOTkuMTgxLjg1IiwibmFtZSI6IkFidSB0cmlrYSIsIm9pZCI6ImNhYjZjMDAwLWNjNjYtNGEwZi05OWIwLWYzZTdlMWQ2MGNmMSIsInB1aWQiOiIxMDAzMjAwMEY3OENFMzQwIiwicHdkX2V4cCI6IjExODQ0MjUiLCJwd2RfdXJsIjoiaHR0cHM6Ly9wb3J0YWwubWljcm9zb2Z0b25saW5lLmNvbS9DaGFuZ2VQYXNzd29yZC5hc3B4IiwicmgiOiIwLkFYa0FmVml0RHRyWWhVVzhOTnJnLWJMdmxsVTZBYVlmeXBkR2lDZDB0MkRDcjVSNUFQYy4iLCJzY3AiOiJVc2VyLlJlYWQiLCJzdWIiOiJDbGRRUEdBd1BSQldLZVBNR0xiMkg4VzZpSG8wc3M2aW1LaTZlU3plYmFBIiwidGVuYW50X3JlZ2lvbl9zY29wZSI6IkFGIiwidGlkIjoiMGVhZDU4N2QtZDhkYS00NTg1LWJjMzQtZGFlMGY5YjJlZjk2IiwidW5pcXVlX25hbWUiOiJ0cmlrYUByZXRhaWwxMC5vbm1pY3Jvc29mdC5jb20iLCJ1cG4iOiJ0cmlrYUByZXRhaWwxMC5vbm1pY3Jvc29mdC5jb20iLCJ1dGkiOiJ4RC1GYk11OWdVV0g4T095bFAwWUFBIiwidmVyIjoiMS4wIn0.Cd6nvoRVPD7YbKBsKd21vxy8GlbfS-XsZsK2hihV7xE-gaE-b0v3ogjO5YU2NEVhFDxIydeCIxLFmgzOXuHRZaCqWHW43Wjc26_EEqSfRHdfyNmK1iHaItAmdx91iqU1o-3ptR9Fuv91kyY9n3tyvcE8WUX6jRanACSQkrnvQCCWB7G0Rh_k2UnwAQXwZ58x6mOfdgg1KBUYJwRpLHTKolo6tXoquCisnuRleKQ7PwYhv4WuMOXbbYFUa-c3L3k8iT2wT04so6FCMaQNxo4BNDX4Gx4HBA9ElLbIs2eOKDi7BTUX8G8jgmNgVZGmP5K3k0y-nVq0NXE6z55JuNgSQw"));
        Map map = new HashMap<String, String >();
        map.put("app-version",this.version);
        logger.info("version --->>>> "+this.version.toString());
        return map;
    }
}
