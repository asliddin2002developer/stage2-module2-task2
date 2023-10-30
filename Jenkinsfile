#!/usr/bin/env groovy
pipeline {
    agent any

    tools {
      maven '3.9.5'
    }

    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonar') {
                    bat 'mvn clean verify sonar:sonar'
                }
            }
        }

        stage("Quality Gate") {
            steps{
                timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
                }
            }
        }
    
    }
}
