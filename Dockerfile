FROM openjdk:8-jdk-alpine
ARG BUILD_NO
RUN echo "Build Number:$BUILD_NO"
MAINTAINER uvsoftgroup
VOLUME /tmp
COPY target/userregistration-1.2.3.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
