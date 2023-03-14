package com.ex.c1.springtest;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootTestApplication {
    public static void main( String[] args ){
        new SpringApplicationBuilder(SpringbootTestApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
