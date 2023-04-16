#
# Build stage
#
FROM maven:3.8.7 AS build
RUN cd ../
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17
COPY --from=build /home/app/target/cursinho.jar /usr/local/lib/cursinho.jar
EXPOSE 8080

ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/usr/local/lib/cursinho.jar"]
