pipeline{
    agent {
         docker{
             image 'puzzle-image'
         }
    }
    tools{
        maven 'apache-maven-3.6.1' 
    }
    stages{
        stage('Build'){
            steps{
                sh 'echo build start!'
                sh 'mvn package'
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
