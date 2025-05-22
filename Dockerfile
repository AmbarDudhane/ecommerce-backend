# Stage 1: Build the application
FROM maven:3.9.5 AS build
WORKDIR /app

# Copy only pom.xml first to cache dependencies
COPY pom.xml /app
RUN mvn dependency:resolve

# Now copy the rest of the source
COPY . /app

# Package using the 'build' profile, skipping tests
RUN mvn clean package -DskipTests -Dspring.profiles.active=build

# Stage 2: Run the application
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]