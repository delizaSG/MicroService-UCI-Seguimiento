package unam.diplomado.uci.uciservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;	

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="seguimientos")
public class Seguimiento {
	@Id
	private String id;
	private String COMENTARIOS;
	private String PERITO;
    private String GOBIERNO;
    private String SIGLAS;
    private String DEPENDENCIA;
    private String CLAVEUC;
    private String NOMBRE_DE_LA_UC;
    private String RESPONSABLE;
    private String NUMERO_EXPEDIENTE;
    private String TITULO_EXPEDIENTE;
    private String PLANTILLA_EXPEDIENTE;

}
