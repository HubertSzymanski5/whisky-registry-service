package pl.szymhu.whiskyregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class WhiskyRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiskyRegistryServiceApplication.class, args);
	}

}
