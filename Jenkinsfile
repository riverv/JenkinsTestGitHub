pipeline{
    agent any
    trigger{
        pollSCM('H/5 * * * *')
    }
    tools{
        maven 'apache-maven-4.0.0' 
    }
    stages{
        stage('Build'){
            steps{
                sh 'mvn package'
            }
        }
        stage('Execute'){
            steps{
                //sh 'mvn exec:java'
            }
        }
    }
    post{
        alweys{
            sh 'Build!'
        }
        success{
            sh 'echo success!'
        }
    }
} 
