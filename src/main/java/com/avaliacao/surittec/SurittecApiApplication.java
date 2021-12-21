package com.avaliacao.surittec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avaliacao.surittec.core.io.Base64ProtocolResolver;

@SpringBootApplication
//@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepository.class)
public class SurittecApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SurittecApiApplication.class);
		app.addListeners(new Base64ProtocolResolver());
		app.run(args);
	}

}
