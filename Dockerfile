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
RUN ./gradlew clean bootJar

FROM eclipse-temurin:17-jre
WORKDIR /app
#COPY service-account-key.json /app/service-account-key.json
#ENV GOOGLE_APPLICATION_CREDENTIALS=/app/service-account-key.json
# Install curl for health check
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

COPY --from=builder /app/build/libs/app.jar app.jar

# Add environment variable for the port
#ENV PORT=8080
#ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

EXPOSE 8080

# Add health check
HEALTHCHECK --interval=5s --timeout=3s --retries=3 \
CMD curl -f http://localhost:8080/health || exit 1

# Use shell form to ensure environment variables are expanded
ENTRYPOINT exec java -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -jar app.jar