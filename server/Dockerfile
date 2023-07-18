FROM eclipse-temurin:17-jdk-alpine
COPY ./build/libs/*.jar server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/server.jar"]