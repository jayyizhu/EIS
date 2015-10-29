package com.tianmaying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan("com.tianmaying")
public class Application 
{
	 public static void main(String[] args) {
	     SpringApplication.run(Application.class, args);
	 }
}
