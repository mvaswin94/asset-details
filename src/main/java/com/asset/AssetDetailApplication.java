package com.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AssetDetailApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssetDetailApplication.class, args);
	}
}
