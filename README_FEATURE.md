# MicroService-UCI-Seguimiento
EndPoint de Consulta de licitaciones de compranet de la Unidad de Control lnterno del IMSS

## Actualizacion
Esta version fue actualizada para desplegar con Mongo Atlas, se upgradea de Local a Cloud
Se actualizaron los manifiestos para la version v1

EL equipo de desarrollo tendra bajar la nueva version y comenzar la nueva linea de la brach uci-v1.0

## Guia
       main
        |
        v
      | A --- B --- C --- D        (main)

                    dev
                     |
                     v
      | A --- B --- C --- D --- E  (dev)

                     dev5
                      |
                      v
      | A --- B --- C --- D --- F  (dev5)

                           feature/unit_testing
                             |
                             v
      | A --- B --- C --- D --- G  (feature/unit_testing)

                                uci-v1.0
                                  |
                                  v
      | A --- B --- C --- D --- H  (uci-v1.0)




## Deploy

Usar el Dockerfile para descargar imagen

Se proporcionan los siguientes scripts para la creación de la base de datos/collections en MongoDB:

* createBD.js
* seguimiento_data.js


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
