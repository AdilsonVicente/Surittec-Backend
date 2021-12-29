package com.avaliacao.surittec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.avaliacao.surittec.core.io.Base64ProtocolResolver;
import com.avaliacao.surittec.infrastructure.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class SurittecApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SurittecApiApplication.class);
		app.addListeners(new Base64ProtocolResolver());
		app.run(args);
	}

}
