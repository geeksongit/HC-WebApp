
# Build Project
mvn clean install

# Create Docker image
docker build -t hc-webapp:1.0 .

# Start Application on container
docker run -d -p 8080:8080 hc-webapp:1.0
