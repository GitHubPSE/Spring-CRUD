package com.example.crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.crud.mapper")  // ✅ MyBatis 매퍼 패키지 스캔 추가
public class CrudDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
}