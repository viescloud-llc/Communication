FROM openjdk:19
EXPOSE 8080
EXPOSE 81
EXPOSE 82
EXPOSE 83
ADD target/communication.jar communication.jar
ENTRYPOINT ["java", "-jar", "/communication.jar"]