# For Java 8
FROM openjdk:8-jdk-alpine

# cd /opt/app
WORKDIR /opt/app

# cp ./target/math-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ./target/math-0.0.1-SNAPSHOT.jar app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]