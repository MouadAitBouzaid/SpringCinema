FROM openjdk:17-jdk-alpine
COPY target/*.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 8085
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]