package com.example.gen_code_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//// @formatter:off
@ComponentScan(
        basePackages = {
                "com.example.gen_code_ai",
                "org.openapitools.configuration"
        }
)
// @formatter:on
public class GenCodeAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenCodeAiApplication.class, args);
    }

}
