#File v1.0 
FROM openjdk:17-oracle
MAINTAINER E dorantes <delizad01@gmail.com>
# env
ENV MONGO_HOSTNAME=localhost
ENV MONGO_PORT=27017
ENV MONGO_AUTHDB=admin
ENV MONGO_DB=seguimientoucdb
ENV MONGO_USER=uc_owner
ENV MONGO_PWD=uc_password
ENV TOMCAT_PORT=8083 
EXPOSE 8083
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
