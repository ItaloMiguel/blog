package br.com.blog.cursinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CursinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursinhoApplication.class, args);
	}

}
