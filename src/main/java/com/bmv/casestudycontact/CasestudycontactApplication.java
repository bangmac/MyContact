package com.bmv.casestudycontact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CasestudycontactApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasestudycontactApplication.class, args);
    }

}
