FROM openjdk:8-jdk-alpine
ADD . /ZuulService
WORKDIR /ZuulService
CMD ["java", "-jar", "target/hydra-gateway-service-0.0.1-SNAPSHOT.jar"]