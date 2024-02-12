FROM eclipse-temurin:17
VOLUME /tmp
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} webapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/webapp.jar"]