package com.example.r2dbcmysql;

import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootTest(properties = "spring.r2dbc.url=r2dbc:tc:mysql:///test?TC_IMAGE_TAG=8.0")
class TestcontainersR2dbcMysqlApplicationTests {

	@Autowired
	private ProfileRepository repository;

	@Test
	void contextLoads() {
		StepVerifier.create(this.repository.count())
				.expectNext(4L)
				.verifyComplete();
	}

	@TestConfiguration
	static class Config {

		@Bean
		ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
			ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
			initializer.setConnectionFactory(connectionFactory);
			initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("db/migration/V1__create_populate_table.sql")));
			return initializer;
		}

	}

}
