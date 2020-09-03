FROM maven:slim as build 
WORKDIR /app 
COPY pom.xml /app/ 
RUN mvn dependency:go-offline 
COPY src /app/src/ 
RUN mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V -e 

FROM java:jre-alpine 
 
WORKDIR /home/usr/app
COPY --from=build /app/target/Izvestaj-0.0.1-SNAPSHOT.jar /home/usr/app/Izvestaj-0.0.1-SNAPSHOT.jar 
 

CMD ["java", "-jar", "/home/usr/app/Izvestaj-0.0.1-SNAPSHOT.jar"]
