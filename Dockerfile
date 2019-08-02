FROM openjdk:11-jre
WORKDIR usr/src
ADD ./target/springbootdemotask-0.0.1-SNAPSHOT.jar /usr/src/springbootdemotask-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/springbootdemotask-0.0.1-SNAPSHOT.jar"]