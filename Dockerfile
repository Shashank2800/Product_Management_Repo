FROM eclipse-temurin:17-jre-jammy
COPY target/Product_Management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
