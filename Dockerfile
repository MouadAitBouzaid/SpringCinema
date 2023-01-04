FROM openjdk:8-jdk-alpine
<<<<<<< Updated upstream
ARG JAR_FILE=film-service/target/*.jar
COPY  ./film-service/target/film-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
=======
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /home/app/target/war_name.war app.war
ENTRYPOINT ["java","-jar","/app.war"]
>>>>>>> Stashed changes
