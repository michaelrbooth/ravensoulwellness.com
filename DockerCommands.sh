# Build the image
docker build -t local/ravensoul-app .

# Run the container
docker run -p 8080:8080 local/ravensoul-app