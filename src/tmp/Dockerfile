FROM openjdk:17-ea-jdk-alpine

RUN mkdir -p /usr/src/app/
WORKDIR /usr/src/app/

COPY build/libs/tmp-0.0.1-SNAPSHOT.jar /usr/src/app/

CMD ["java", "-jar", "tmp-0.0.1-SNAPSHOT.jar"]