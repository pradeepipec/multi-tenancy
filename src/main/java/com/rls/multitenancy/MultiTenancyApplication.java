package com.rls.multitenancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class MultiTenancyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MultiTenancyApplication.class, args);
    }

}

