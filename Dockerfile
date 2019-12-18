FROM openjdk:8-jre-alpine
EXPOSE 8080
ARG JAR_FILE=impl/target/product-management.jar
ADD ${JAR_FILE} product-management.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/product-management.jar"]