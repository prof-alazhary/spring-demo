package com.example.mydemo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.http.HttpServletRequest;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public WebSecurityConfig(RequestContextFilter request) {
//        String token =  request.getHeader("Authorization").toString();
//        System.out.println("constructor ---> HttpServletRequest --->>>> " +token);
//        if(token!= null){
//
//            String[] jwt_arr = token.split(" ");
//            String jwt_only = jwt_arr[1];
//            int i = jwt_only.lastIndexOf('.');
//            String withoutSignature = jwt_only.substring(0, i+1);
//            System.out.println("withoutSignature --->>>> " + withoutSignature.toString());
//
//            Jwt<Header, Claims> untrusted = Jwts.parser().parseClaimsJwt(withoutSignature);
//
//            System.out.println("untrusted --->>>> " + untrusted.toString());
//        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new JWTFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
//                .addFilterAfter(new MDCFilter(), JWTFilter.class);
    }

}
