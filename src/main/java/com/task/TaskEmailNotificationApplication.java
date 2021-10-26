package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableSwagger2
public class TaskEmailNotificationApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(TaskEmailNotificationApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TaskEmailNotificationApplication.class, args);
		LOGGER.info("Application Started at port 8080");
	}

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
}
