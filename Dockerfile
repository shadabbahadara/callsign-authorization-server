FROM openjdk:8
COPY ./target/callsign-authorization-server-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]