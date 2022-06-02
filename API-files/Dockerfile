FROM openjdk:17-alpine
ARG JAR_FILE=devfy-0.0.1-SNAPSHOT.jar
COPY target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]