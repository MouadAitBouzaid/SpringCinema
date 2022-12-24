FROM openjdk:8-jdk-alpine
ARG JAR_FILE=film-service/target/*.jar
COPY  ./film-service/target/film-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]