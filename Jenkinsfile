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
}
