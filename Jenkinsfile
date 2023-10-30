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

        stage('Quality Gates') {
            steps {
                  waitForQualityGate abortPipeline: true
            }
          
        }
    
    }
}
