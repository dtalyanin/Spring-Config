FROM openjdk:7-jdk-alpine
COPY ./client/build/libs/*.jar client.jar
EXPOSE 8080
ENTRYPOINT java -XX:+PrintFlagsFinal -jar /client.jar