
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Compiles the code and creates the JAR
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run Application') {
            steps {
                // Runs the JAR. Port 9090 used to avoid conflict with Jenkins
                bat 'java -jar target/Product_Management-0.0.1-SNAPSHOT.jar --server.port=9090'
            }
        }
    }

    post {
        success {
            // Saves the JAR file in the Jenkins dashboard
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
