package unam.diplomado.uci.uciservice.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.uci.uciservice.domain.Seguimiento;


@RequestMapping(path="api/seguimiento", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="seguimiento", description = "API del Recurso Seguimiento UCI")
public interface SeguimientoApi {
	
	@Operation(summary = "Consulta Seguimiento")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", 
		description = "Seguimiento Encontrado", 
	    content = { 
	    	@Content(mediaType="application/json", 
	    	schema = @Schema(implementation=Seguimiento.class)) }),
	   })
	
	@PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
	Seguimiento consultarSeguimiento(@RequestBody Seguimiento seguimiento);
	
	
	
	

}
