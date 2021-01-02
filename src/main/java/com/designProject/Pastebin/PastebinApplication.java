package com.designProject.Pastebin;

import com.designProject.Pastebin.JpaRepository.PastebinRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackageClasses = PastebinRepository.class)
public class PastebinApplication {

	public static void main(String[] args) {

		SpringApplication.run(PastebinApplication.class, args);
	}

}
