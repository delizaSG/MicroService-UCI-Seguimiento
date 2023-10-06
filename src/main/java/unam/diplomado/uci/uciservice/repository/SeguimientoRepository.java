package unam.diplomado.uci.uciservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import unam.diplomado.uci.uciservice.domain.Seguimiento;


public interface SeguimientoRepository 
	extends MongoRepository<Seguimiento, String>{

}

