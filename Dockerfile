FROM eclipse-temurin:17-jdk-focal
WORKDIR /app

COPY .mvn ./.mvn
COPY src ./src
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

RUN ./mvnw package

EXPOSE 3001
