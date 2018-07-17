FROM openjdk:8-jdk-alpine
ADD target/BodymassIndexCalculator-0.0.1.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
