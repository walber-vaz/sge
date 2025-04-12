FROM maven:3.9.9-eclipse-temurin-21 AS build
LABEL authors="sge"
LABEL description="Builds the Java application"

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim AS runtime
LABEL authors="sge"
LABEL description="Runs the Java application"

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]