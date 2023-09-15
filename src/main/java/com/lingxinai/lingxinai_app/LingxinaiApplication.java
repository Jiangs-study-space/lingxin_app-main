package com.lingxinai.lingxinai_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class LingxinaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LingxinaiApplication.class, args);
    }

}
