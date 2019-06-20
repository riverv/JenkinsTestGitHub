#!groovy
pipeline{
    agent {
        docker {image 'maven: 3-alpine'}
    }
    stages{
       stage('Build'){
            steps{
                sh 'echo "image docker"'
            }
       }
    }
} 
