pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Changed 'sh' to 'bat' for Windows compatibility
                bat 'mvn clean package -DskipTests'
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
    stage('Run Application') {
    steps {
        // This runs the JAR using Java. 
        // Use 'bat' for Windows, 'sh' for Linux.
        bat 'java -jar target/Product_Management-0.0.1-SNAPSHOT.jar'
    }
}
}
