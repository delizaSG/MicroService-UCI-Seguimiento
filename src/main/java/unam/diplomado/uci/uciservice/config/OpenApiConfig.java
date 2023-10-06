package unam.diplomado.uci.uciservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
		info = @Info (
				version = "v1",
				title = "UCI Seguimientos Microservice Endpoints",
				description = "Definicion de los Endpoints de Unidad de Control Interno para el Sistema de seguimientos",
				contact = @Contact(
						name = "UNAM",
						url = "https://www.unam.mx",
						email = "delizad01@gmail.com")
				)
		)

public class OpenApiConfig {

}
