pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        // stage('SonarQube Analysis') {
        //     steps {
        //         // Ensure 'SonarServer' matches the name in Jenkins > System
        //         withSonarQubeEnv('SonarServer') {
        //             bat 'mvn sonar:sonar'
        //         }
        //     }
        // }

        stage('Build Docker Image') {
            steps {
                // Creates a Docker image from a 'Dockerfile' in your root directory
                bat 'docker build -t my-spring-app:latest .'
            }
        }

        stage('Run in Docker') {
            steps {
                // Stops any old container and starts a new one on port 9090
                // bat 'docker stop my-app || true'
                // bat 'docker rm my-app || true'
                bat 'docker run -d --name my-app -p 9090:8082 my-spring-app:latest'
            }
        }
    }
}
