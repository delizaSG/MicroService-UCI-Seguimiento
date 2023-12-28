# --> cafaray:
#    Como parte de los principios de integración y entrega continua
#    se recomienda usar los mecanismos de compilación en las tareas/tuberias.
#    Es de esta forma que se puede mantener más control sobre los procesos de
#    compilación y despliegue de la aplicación.
# <-- cafaray

# Incluir la ruta completa de la imagen para evitar problemas de short-name
FROM docker.io/openjdk:17-oracle

# Establece los valores de entorno para la aplicación
ENV MONGO_URI=mongodb+srv://uc_owner:uc_password@atlascluster.3xl2sha.mongodb.net/seguimientoucdb?retryWrites=true&w=majority
ENV TOMCAT_PORT=8083

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado en la etapa anterior
# COPY --from=build /usr/src/app/target/uci-service-0.0.1-SNAPSHOT.jar /app/uci-service.jar
COPY target/uci-service-*.jar /app/uci-service.jar

# Puerto de exposición
EXPOSE 8083

# Comando para ejecutar la aplicación al iniciar el contenedor
# CMD ["java", "-jar", "/app/uci-service.jar"]
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "/app/uci-service.jar"]
