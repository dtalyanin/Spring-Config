FROM eclipse-temurin:17-jdk-alpine
COPY ./build/libs/*.jar client.jar
EXPOSE 8080
ENTRYPOINT java ${JAVA_OPTS} -jar /client.jar