package com.example.mydemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {
    //is that valid to create class without constructor??

    @Bean
    public DataSource configDataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        System.out.println("HIIII,,,,,,,,,,,");
        builder.url("jdbc:postgresql://localhost:5432/conference_app");
        builder.username("postgres");
        builder.password("Welcome");
        return builder.build();
    }
}
