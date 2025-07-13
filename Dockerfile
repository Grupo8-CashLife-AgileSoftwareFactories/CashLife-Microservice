From eclipse-temurin:21-jdk as builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY . .

# Grant execution permissions to mvnw
RUN chmod +x ./mvnw
RUN apt-get update && apt-get install -y maven
RUN mvn package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]