package com.chunhodong.chbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ChbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChbookApplication.class, args);
	}

}
