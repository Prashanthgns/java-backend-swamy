package com.ani.springdata.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataJdbcApplication.class, args);
	}
//		ApplicationContext ctx = SpringApplication.run(SpringDataJdbcApplication.class, args);
//		DbService service = ctx.getBean(DbService.class);
//		service.saveCar();
}
