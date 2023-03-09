FROM maven:3.6-openjdk-8 as builder

WORKDIR /app
COPY . /app
RUN mvn package -DskipTests=true

FROM openjdk:8
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/app.jar .
CMD ["java", "-jar", "-Duser.timezone=Asia/Shanghai", "-Dspring.profiles.active=docker", "-Dserver.port=8080", "/app/app.jar"]
