FROM eclipse-temurin:17-jdk-focal

WORKDIR /usr/src/app

COPY .mvn .mvn
COPY mvnw ./
COPY pom.xml ./
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]