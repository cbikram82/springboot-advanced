FROM openjdk:17-jdk-slim
# Create a working directory for the application
WORKDIR /app

# Copy the built JAR file from the target folder to the container
ARG JAR_FILE=target/bootTutorial-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose the port on which the app will run (default is 8080)
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]