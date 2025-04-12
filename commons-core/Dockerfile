FROM maven:3.9.9-eclipse-temurin-21
LABEL authors="sge"
LABEL description="Builds the common library"

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests