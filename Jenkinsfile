pipeline{
    agent {
         docker{
             image 'puzzle-image'
         }
    }
    tools{
        maven 'apache-maven-4.0.0' 
    }
    stages{
        stage('Build'){
            steps{
                sh 'echo build start!'
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
        always{
            sh 'Build!'
        }
        success{
            sh 'echo success!'
        }
    }
} 
