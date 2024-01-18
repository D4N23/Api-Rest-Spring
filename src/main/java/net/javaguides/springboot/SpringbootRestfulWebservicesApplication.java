package net.javaguides.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Spring Boot Api Documentation",
		description = "v1.0",
		contact = @Contact(
			name = "Danilo ",
			email = "daniilosam23@gmail.com",
			url = "https://www.linkedin.com/in/danilo-sampaio-86162a150/"
		),
		license = @License(
			name = "Apache 2.0",
			url = "https://navita.com.br/blog/quais-os-tipos-de-licenca-de-softwares-conheca-elas-aqui/"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Spring Boot User Management Documentation",
		url =  "https://chat.openai.com/share/effab2ad-0e2c-47ff-afda-b362eca71bda"
	)
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
