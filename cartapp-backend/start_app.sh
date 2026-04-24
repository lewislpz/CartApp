#!/bin/bash
"""
Script to start the Spring Boot application
"""

# Get the directory where this script is located
script_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Change to the project directory
cd "$script_dir"

echo "Starting Spring Boot application..."
echo "Running: mvn spring-boot:run"

# Run the Maven command to start the Spring Boot app
mvn spring-boot:run

# Check if the command was successful
if [ $? -eq 0 ]; then
    echo "Spring Boot application started successfully!"
else
    echo "Spring Boot application failed to start."
    exit 1
fi
