FROM openjdk

ADD ./api-balance-service/target/api-balance-service-0.0.1-SNAPSHOT.jar api-balance-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/api-balance-service.jar"]