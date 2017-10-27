FROM java:8  
COPY target/dataSource-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/app.jar
WORKDIR /usr/app
CMD ["java", "-cp", "app.jar" ,"SubscribeToOpenChannel"]