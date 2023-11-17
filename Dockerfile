# Usa la imagen oficial de Maven como imagen base
FROM maven:3.8.4-openjdk-17-slim AS build
MAINTAINER elizabeth dorantes <delizad01@gmail.com>

# Copia los archivos de configuración y el código fuente
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Establece el directorio de trabajo
WORKDIR /usr/src/app

# Variables de entorno
# env
#ENV MONGO_HOSTNAME=localhost
#ENV MONGO_PORT=27017
#ENV MONGO_AUTHDB=admin
#ENV MONGO_DB=seguimientoucdb
#ENV MONGO_USER=uc_owner
#ENV MONGO_PWD=uc_password

ENV MONGO_URI=mongodb+srv://uc_owner:uc_password@atlascluster.3xl2sha.mongodb.net/seguimientoucdb?retryWrites=true&w=majority
ENV TOMCAT_PORT=8083
EXPOSE 8083

# Compila la aplicación
RUN mvn clean package

# Cambia a una imagen más ligera de Java para la ejecución
FROM openjdk:17-oracle

# Copia el archivo JAR generado en la etapa anterior
COPY --from=build /usr/src/app/target/uci-service-0.0.1-SNAPSHOT.jar /app/uci-service.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8083

# Comando para ejecutar la aplicación al iniciar el contenedor
#CMD ["java", "-jar", "/app/uci-service.jar"]
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "/app/uci-service.jar"]

