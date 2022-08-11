FROM openjdk:8-jdk-alpine
ADD target/flight-service.jar flight-service.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "flight-service.jar"]