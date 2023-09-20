FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add bash curl
LABEL authors="André Garcia Pereira"
WORKDIR /app
COPY target/*.jar /app/incloo-eureka-server.jar
ENTRYPOINT ["java","-jar","incloo-eureka-server.jar"]