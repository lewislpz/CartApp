#!/usr/bin/env python3
"""
Script to start the Spring Boot application
"""

import subprocess
import sys
import os
import time

def start_spring_boot_app():
    """
    Start the Spring Boot application using Maven
    """
    try:
        # Get the directory where this script is located
        script_dir = os.path.dirname(os.path.abspath(__file__))
        
        # Change to the project directory
        os.chdir(script_dir)
        
        print("Starting Spring Boot application...")
        print("Running: mvn spring-boot:run")
        
        # Run the Maven command to start the Spring Boot app
        process = subprocess.Popen(
            ["mvn", "spring-boot:run"],
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            text=True,
            bufsize=1
        )
        
        # Print output in real-time
        print("Application output:")
        print("-" * 50)
        
        # Read output line by line
        while True:
            output = process.stdout.readline()
            if output == '' and process.poll() is not None:
                break
            if output:
                print(output.strip())
        
        return_code = process.poll()
        if return_code == 0:
            print("Spring Boot application started successfully!")
        else:
            print(f"Spring Boot application failed to start. Exit code: {return_code}")
            # Also print stderr
            stderr_output = process.stderr.read()
            if stderr_output:
                print(f"Error output: {stderr_output}")
            return False
            
    except FileNotFoundError:
        print("Error: Maven is not installed or not in PATH")
        print("Please install Maven and ensure it's in your system PATH")
        return False
    except Exception as e:
        print(f"Error starting Spring Boot application: {e}")
        return False

def check_maven():
    """
    Check if Maven is available
    """
    try:
        subprocess.run(["mvn", "--version"], check=True, 
                      stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        return True
    except (subprocess.CalledProcessError, FileNotFoundError):
        return False

if __name__ == "__main__":
    if not check_maven():
        print("Maven is required to start the Spring Boot application.")
        print("Please install Maven and ensure it's in your system PATH.")
        sys.exit(1)
    
    start_spring_boot_app()
