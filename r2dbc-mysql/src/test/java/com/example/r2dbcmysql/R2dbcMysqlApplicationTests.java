package com.example.r2dbcmysql;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

@SpringBootTest
@Testcontainers
class R2dbcMysqlApplicationTests {

	@Container
	@ServiceConnection
	static MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0");

	@Autowired
	private ProfileRepository repository;

	@Test
	void contextLoads() {
		StepVerifier.create(this.repository.count())
				.expectNext(4L)
				.verifyComplete();
	}

}
