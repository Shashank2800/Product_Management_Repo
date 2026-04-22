pipeline {
    agent any
    
    tools { 
        // Must match the name defined in Jenkins 'Global Tool Configuration'
        maven 'Maven3' 
        jdk 'Java17' 
    }
    
    stages {
        stage('Build') {
            steps {
                // Generates the JAR file in the 'target' folder
                sh 'mvn clean package -DskipTests'
            }
        }
    }
    
    post {
        success {
            // Archives the JAR from the Maven 'target' directory
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
