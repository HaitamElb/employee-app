FROM openjdk:19-alpine
ADD target/*.jar
ENTRYPOINT ["java","-jar","target/*.jar"]
