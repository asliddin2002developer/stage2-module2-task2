#!/usr/bin/env groovy
pipeline {
    agent any

    tools {
      maven '3.9.5'
    }

    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonar1') {
                    bat 'mvn clean verify sonar:sonar'
                }
            }
        }

        stage('Quality Gates') {
          timeout(time: 1, unit: 'HOURS')
          def qg = waitForQualityGate()
          if (qg.status != 'OK') {
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
          }
        }
    
    }
}
