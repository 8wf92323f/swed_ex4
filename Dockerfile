# run 'mvn package' first
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY /target/*.jar ./monitorapp.jar
CMD ["java", "-jar", "monitorapp.jar", "www.example.com"]