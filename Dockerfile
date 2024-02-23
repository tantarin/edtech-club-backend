FROM eclipse-temurin:17-jdk-focal

WORKDIR /usr/src/app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
COPY init.sql ./
CMD ["./mvnw", "spring-boot:run"]