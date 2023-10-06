# MicroService-UCI-Seguimiento
EndPoint de Consulta de licitaciones de compranet de la Unidad de Control lnterno del IMSS

## Project
Implementacion del microservicio para seguimiento de licitaciones publicas del IMSS
Este servicio registrara comentarios de seguimiento.

-- Registra Comentario  :: Registra los comentarios de seguimiento que realice el perito
-- Registra Perito :: Registra el nombre del abogado que lleva el seguimiento
-- Consulta seguimiento :: Muestra la informacion del seguimiento

Se proporcionan los siguientes scripts para la creación de la base de datos/collections en MongoDB:

* createBD.js
* seguimiento_data.js

# MicroService-UCI-Tracking
Consultation EndPoint for Compranet Bidding of the Internal Control Unit of IMSS

## Project
Implementation of the microservice for public tender tracking at IMSS
This service will record tracking comments.

-- Register Comment  :: Records the tracking comments made by the expert
-- Register Expert :: Records the name of the lawyer handling the tracking
-- Track Progress Query :: Displays tracking information

The following scripts are provided for the MongoDB database/collections creation:
* createBD.js
* seguimiento_data.js


## Deploy

`// TODO `

## Test

Execute the next `curl` command to validate the deploy of the service. 

shell
curl -v  http://localhost:8083/seguimiento


The expected result should looks like:
{

        "id": "55af0ea155827301001a0cc9",
	
        "comentarios": "Se aprobo el dictamen pero se rechazo en el UCI de la seccion 22 por falta de chuleta de documentos",
	
        "perito": "Mtro. Pedro Diaz ",
	
        "gobierno": "APF",
	
        "siglas": "IMSS",
	
        "dependencia": "Instituto Mexicano del Seguro Social",
	
        "claveuc": "019GYR055",
	
        "nombre_DE_LA_UC": "IMSS-Hospital de Especialidades Dr. Antonio Fraga Mouret",
	
        "responsable": "Ernesto Alonso Ayala López",
	
        "numero_EXPEDIENTE": "718952",
	
        "titulo_EXPEDIENTE": "SERVICIO INTEGRAL DE HEMODINAMIA, ANGIOLOGIA Y NEUROLOGIA",
	
        "plantilla_EXPEDIENTE": "01. Licitación Pública Nacional LAASSP"
	
    }
 
### Reference Documentation
For further reference, please consider the following sections:
* [Official Page of Government API] https://datos.gob.mx/blog/catalogo-apidatosgobmx
* [Officil Page for Public Access Data Query of system Compranet] https://api.datos.gob.mx/v1/compranet?_id=55af0dbd558273010015a0b4
* [Officil Page for Public Access Data Query of the Government] https://datos.gob.mx/blog/api-datosgobmx
  
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
