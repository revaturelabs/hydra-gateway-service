FROM openjdk:8-jdk-alpine
ADD . /zuul
WORKDIR /zuul
EXPOSE 8800
CMD ["java", "-jar", "target/hydra-gateway-service-0.0.1-SNAPSHOT.jar"]