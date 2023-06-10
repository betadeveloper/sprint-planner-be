FROM openjdk:17.0.1

COPY sprint/build/libs/sprint-*-SNAPSHOT.jar /sprint.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/sprint.jar"]