FROM eclipse-temurin:17-jdk-focal
WORKDIR /app

COPY .mvn ./.mvn
COPY src ./src
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY scripts/start-application.sh .
COPY tools ./tools

RUN chmod +x start-application.sh

RUN ./mvnw package

EXPOSE 8444

ENTRYPOINT ["./start-application.sh"]
