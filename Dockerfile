FROM openjdk:11
VOLUME /tmp
COPY target/k8s-demo.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]