FROM amazoncorretto:17.0.12

WORKDIR /app

COPY build/libs/reports-0.0.1-SNAPSHOT.jar /app/reports-0.0.1-SNAPSHOT.jar

EXPOSE 8084:8084

CMD ["java", "-jar", "reports-0.0.1-SNAPSHOT.jar"]