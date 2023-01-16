package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
@EnableWebMvc
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("payroll-empeeloy").apiInfo(apiInfo()).select().build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("user API").description("Spring Boot Swagger2 Example API")
				.termsOfServiceUrl("Terms of Service").license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/").version("1.0").build();

	}


}
