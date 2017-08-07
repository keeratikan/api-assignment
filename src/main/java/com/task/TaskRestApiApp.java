package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.task"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class TaskRestApiApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(TaskRestApiApp.class, args);
    }
}
