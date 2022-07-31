FROM openjdk:11
COPY user-service-0.0.1.jar /user-service-0.0.1.jar
CMD ["java","-jar","user-service-0.0.1.jar"]