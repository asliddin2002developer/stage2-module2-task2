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

        stage ('Deploy') {
            steps {
                script {
                  deploy adapters: [tomcat9(credentialsId: 'b78facb6-0eeb-45a2-8982-f5e419ea99e9', path: '', url: 'http://localhost:8080')], contextPath: '/pipeline', onFailure: false, war: 'target/*.war' 
                }
            }\
        }
    
    }
}
