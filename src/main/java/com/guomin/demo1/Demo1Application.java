package com.guomin.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

    //自动创建spring 容器，并自动装配bean，进行扫描
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
