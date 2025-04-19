# Base image ni select cheyyandi (OpenJDK 17 use chesthunna)
FROM openjdk:17-jdk-alpine

# Container lo work cheyadaniki folder create cheyyandi
WORKDIR /app

# Jar file ni container lo copy cheyyandi
COPY target/app-0.0.1-SNAPSHOT.jar app.jar

# Port 8080 expose cheyyandi (Spring Boot application run avvadani ki)
EXPOSE 8080

# Spring Boot application ni run cheyyandi
ENTRYPOINT ["java", "-jar", "app.jar"]
