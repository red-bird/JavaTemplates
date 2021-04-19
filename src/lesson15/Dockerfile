FROM openjdk:17-ea-jdk-alpine

RUN mkdir -p /usr/src/app/
WORKDIR /usr/src/app/

COPY build/libs/lesson15-0.0.1-SNAPSHOT.jar /usr/src/app/

ENV datasource="postgres"
CMD ["java", "-jar", "lesson15-0.0.1-SNAPSHOT.jar"]