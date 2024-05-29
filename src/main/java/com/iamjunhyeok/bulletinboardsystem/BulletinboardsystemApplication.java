package com.iamjunhyeok.bulletinboardsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BulletinboardsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulletinboardsystemApplication.class, args);
	}

}
