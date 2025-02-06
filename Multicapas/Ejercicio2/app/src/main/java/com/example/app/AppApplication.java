package com.example.app;

import com.example.app.service.NameServiceInt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Bean
	public NameServiceInt nameService() {
		return new NameServiceInt() {
			public List<String> ordenarNombres(List<String> nombres) {
				return List.of();
			}
		};
	}

}
