FROM eclipse-temurin:17-jdk-alpine

ARG JAR_FILE=target/financial-information-microservice-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
