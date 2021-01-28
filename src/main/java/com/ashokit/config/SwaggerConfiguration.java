package com.ashokit.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	
	@Bean
	public ApiInfo createApiInfo() {
		return new ApiInfoBuilder()
				.title("ED Rules Api")
				.description("dveloped by ashokit")
				.version("1.1")
				.build();
	}
	
	@Bean
	public Docket crateDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Rules API")
				.apiInfo(createApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ashokit"))
				.paths(PathSelectors.any())
				.build();
	}
}
