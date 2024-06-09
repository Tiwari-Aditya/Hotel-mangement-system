FROM openjdk:17-jdk

WORKDIR /app

COPY target/hotel-management-0.0.1-SNAPSHOT.jar /app/hotel-management.jar

EXPOSE 9090

CMD ["java","-jar","hotel-management.jar" ]
