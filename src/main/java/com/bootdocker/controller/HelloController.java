package com.bootdocker.controller;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.HikariDataSource;

@RestController
public class HelloController {
	@Autowired
	private DataSource dataSource;
	
	@GetMapping("/hello")
	public String helloDocker() {
		Integer idleConnection = new HikariDataSourcePoolMetadata((HikariDataSource) dataSource).getIdle();
		return "Hello Docker! Idle connection to database is " + idleConnection;
	}
}
