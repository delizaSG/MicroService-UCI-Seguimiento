# MicroService-UCI-Seguimiento
EndPoint de Consulta de licitaciones de compranet de la Unidad de Control lnterno del IMSS

## Project
Implementacion del microservicio para seguimiento de licitaciones publicas del IMSS

Este servicio consulta comentarios de seguimiento.

-- Consulta seguimiento :: Muestra la informacion del seguimiento que realice el perito que lleva el seguimiento


API que llena datos en MongoDB, una interfaz de usuario para capturar comentarios y asociarlos a un seguimiento, un servicio que consume una API para actualizar una base de datos en MongoDB, y un servicio con un método que consulta la información:

**Componentes:**

1. **API de Llenado de Datos en MongoDB**: Representa el componente externo que llena datos en la base de datos MongoDB.Por API REST que recopila datos y los almacena en la base de datos( https://api.datos.gob.mx/v1/compranet?_id=55af0dbd558273010015a0b4).

2. **Interfaz de Usuario (UI)**: Muestra la interfaz de usuario donde los usuarios pueden capturar comentarios y asociarlos a un seguimiento. 

3.  **Servicio de Consulta**: El componente de servicio de consulta permite a los usuarios buscar y recuperar información de la base de datos MongoDB Atlas.

**Diagrama de Flujo de Datos:**

1. Los datos fluyen desde la Interfaz de Usuario (UI) cuando un usuario solicita la consulta de un seguimiento.

2. Estos datos se envían a través de una solicitud a la API seguimientoUCI.

3. El Servicio de Consulta permite a los usuarios buscar y recuperar los comentarios asociados a un seguimiento.

<img src="img/javaV2.PNG" alt="seguimientoUCI microservicio java">


# MicroService-UCI-Tracking
Consultation EndPoint for Compranet Bidding of the Internal Control Unit of IMSS

## Project
Implementation of the microservice for public tender tracking at IMSS

This service queries tracking comments

-- Tracking Query :: Displays the information of the tracking performed by the expert in charge of the tracking.

The following scripts are provided for the MongoDB database/collections creation:
* createBD.js
* seguimiento_data.js


## Deploy

Usar el Dockerfile para descargar imagen

Se proporcionan los siguientes scripts para la creación de la base de datos/collections en MongoDB:

* createBD.js
* seguimiento_data.js


### Creating the image

This image is based on [arm64/jdk-17](https://hub.docker.com/layers/arm64v8/openjdk/17-ea-16-jdk/images/sha256-149f7dbd5287cb06efc8c5d0dfffeffcc36e8a9872dca7736ef8c333a3eca6a2?context=explore) for Mac OS. 

Openjdk:17-oracle es una imagen de contenedor que utiliza OpenJDK versión 17 proporcionada por Oracle

The complete specification of the image that contains the application is in the [Dockerfile](./Dockerfile)

```
### Run with Tekton
#### Setting the environment
Apply the configuration of the app
```shell
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/resources/secret.yaml
```
Set the user and password of github and docker. There are not sample files to use your own users. 
```shell
oc apply -f github-user-pass.yaml 
oc apply -f docker-user-pass.yaml
```
Link those secrets to the "pipeline" service account
#### Set the tasks
```shell
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/tasks/tkrn-1-git-clone-2.yaml
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/tasks/tkrn-2-lkist-dir.yaml
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/tasks/tkrn-3-maven.yaml
oc apply -f https://github.com/delizaSG/MicroService-UCI-Seguimiento/blob/main/manifests/tekton/tasks/tkrn-4-build.yaml
```
#### Optionally apply the taskruns
```shell
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/tasks/tkrn-1-git-clone-2.yaml
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/tasks/tkrn-2-lkist-dir.yaml
oc apply -f https://raw.githubusercontent.com/delizaSG/MicroService-UCI-Seguimiento/main/manifests/tekton/tasks/tkrn-3-maven.yaml
oc apply -f https://github.com/delizaSG/MicroService-UCI-Seguimiento/blob/main/manifests/tekton/tasks/tkrn-4-build.yaml
```
#### Set and run the pipeline

```
### Trigger it from github


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
