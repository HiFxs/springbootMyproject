package com.hifix.springbootmyfirstproject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hifix.springbootmyfirstproject.dao")
@SpringBootApplication
public class SpringbootMyfirstprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMyfirstprojectApplication.class, args);
    }

}
