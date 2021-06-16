package dev.debride.receiptparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"dev.debride.receiptparser"})
@EnableJpaRepositories(basePackages = {"dev.debride.receiptparser.repos"})
@EntityScan(basePackages = {"dev.debride.receiptparser.models"})
@SpringBootApplication
public class ReceiptparserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiptparserApplication.class, args);
	}

}
