package com.bawangbai.boot_redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bawangbai")
public class BootRedissonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRedissonApplication.class, args);
	}

}
