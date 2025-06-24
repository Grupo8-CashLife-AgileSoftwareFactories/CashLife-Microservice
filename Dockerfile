FROM openjdk:21-jdk-slim
LABEL authors='Usuario'

# Crear usuario no root
RUN useradd -ms /bin/bash appuser
# Instalar dependencias necesarias
RUN apt-get update && \
    apt-get install -y curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

VOLUME /app/logs /app/config /app/data /app/temp /app/uploads /app/backups /app/keys /app/scripts

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=prod

HEALTHCHECK --interval=30s --timeout=10s --start-period=10s --retries=3 CMD curl -f http://localhost:8080/actuator/health || exit 1

USER appuser

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar app.jar"]
