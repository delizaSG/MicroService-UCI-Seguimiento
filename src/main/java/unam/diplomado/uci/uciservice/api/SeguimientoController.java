package unam.diplomado.uci.uciservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.uci.uciservice.domain.Seguimiento;
import unam.diplomado.uci.uciservice.repository.SeguimientoRepository;
import unam.diplomado.uci.uciservice.service.SeguimientoService;

// Extra del documento
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="seguimiento", produces="application/json")
@CrossOrigin(origins="*")
public class SeguimientoController {

	@Autowired 
	private SeguimientoRepository seguimientoRepository;
	
	/*
	@Autowired
	private SeguimientoService seguimientoService;
	*/
	

	@GetMapping                                 
	public Iterable<Seguimiento> obtenerSeguimientos(){
			return seguimientoRepository.findAll();       
    }   	
	
	
	@PostMapping(consumes="application/json")
	public Seguimiento crearSeguimiento(@RequestBody Seguimiento seguimiento)
	{	
		return seguimientoRepository.save(seguimiento);
	}

	@GetMapping("{id}")
	public Seguimiento seguimientoPorId(@PathVariable("id") String id) {
		Optional<Seguimiento> seguimiento = seguimientoRepository.findById(id);
		if(seguimiento.isPresent()) {
			return seguimiento.get();
		}
		return null;
	}
	
	
	
}                                          
