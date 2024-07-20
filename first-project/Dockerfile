FROM openjdk
LABEL maintainer="gupta"
ADD target/first-project-0.0.1-SNAPSHOT.jar tododockerimage.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","tododockerimage.jar"]