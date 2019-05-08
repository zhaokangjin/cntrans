package cn.cntrans.platform.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* @MapperScan("com.platform.field.mapping.dao.**") */
public class PlatformServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(PlatformServiceApp.class, args);
	}
}