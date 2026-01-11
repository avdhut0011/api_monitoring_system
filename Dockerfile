# Base image (Java 21 runtime)
FROM eclipse-temurin:21-jre

# Create app directory inside container
WORKDIR /app

# Copy jar from target folder
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
