FROM openjdk:17-jdk-slim-buster
VOLUME /tmp
EXPOSE 8082
ADD ./build/libs/dbz-msa-favorite-characters-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java" , "-jar", "/app.jar"]