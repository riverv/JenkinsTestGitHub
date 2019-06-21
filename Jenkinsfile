#!groovy
pipeline{
    agent {
        docker {image 'puzzle-image'}
    }
    stages{
       stage('Build'){
            steps{
                sh 'echo "lets build"'
                sh 'mvn compile'
            }
       }
    }
} 
