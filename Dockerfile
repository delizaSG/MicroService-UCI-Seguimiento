# Usa la imagen oficial de Maven como imagen base
FROM maven:3.8.4-openjdk-17-slim AS build
MAINTAINER elizabeth dorantes <delizad01@gmail.com>

# Copia los archivos de configuración y el código fuente
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Establece el directorio de trabajo
WORKDIR /usr/src/app

# Variables de entorno
ENV MONGO_HOSTNAME mongodb+srv://cluster0.o4bb8ho.mongodb.net/seguimientoucdb
ENV MONGO_DB seguimientoucdb
ENV MONGO_USER uc_user
ENV MONGO_PWD uc_password
ENV TOMCAT_PORT 8080

# Compila la aplicación
RUN mvn clean install

# Cambia a una imagen más ligera de Java para la ejecución
FROM openjdk:11-jre-slim

# Copia el archivo JAR generado en la etapa anterior
COPY --from=build /usr/src/app/target/uci-service-0.0.1-SNAPSHOT.jar /app/uci-service.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "/app/uci-service.jar"]

