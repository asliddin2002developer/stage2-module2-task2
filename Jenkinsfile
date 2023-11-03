pipeline {
  agent any
  stages {
    stage('Scan') {
      steps {
        withSonarQubeEnv('sonar') {
          bat 'mvn clean verify sonar:sonar'
        }

      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 1, unit: 'HOURS') {
          waitForQualityGate true
        }

      }
    }

    stage('Deploy') {
      steps {
        script {
          deploy adapters: [tomcat9(credentialsId: 'deploy-tomcat', path: '', url: 'http://localhost:8080')], contextPath: '/pipeline-example', onFailure: false, war: 'target/*.war'
        }

      }
    }

  }
  tools {
    maven '3.9.5'
  }
}