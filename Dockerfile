FROM eclipse-temurin:17-jdk as builder
WORKDIR /app

# Copy Gradle files
COPY gradle/ gradle/
COPY gradlew build.gradle.kts settings.gradle ./

# Fix line endings and make gradlew executable
RUN sed -i 's/\r$//' gradlew && \
    chmod +x gradlew

# Verify Gradle wrapper and download dependencies
RUN ./gradlew --version
RUN ./gradlew dependencies

# Copy source code
COPY src/ src/

# Build the application
RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jre
WORKDIR /app
# Create a directory for the jar
RUN mkdir -p /app/libs/
# Copy the jar file(s)
COPY --from=builder /app/build/libs/*.jar /app/libs/
# Use the jar file
# Add environment variable for the port
ENV PORT=8080
EXPOSE ${PORT}

# Add health check
HEALTHCHECK --interval=5s --timeout=3s --retries=3 \
  CMD curl -f http://localhost:${PORT}/ || exit 1

ENTRYPOINT ["java", "-jar", "/app/libs/ravensoulwellness-0.0.1-SNAPSHOT.jar"]