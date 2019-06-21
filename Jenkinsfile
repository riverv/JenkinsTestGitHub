#!groovy
pipeline{
    agent {
        docker {image 'puzzle-image'}
    }
    stages{
       stage('Build'){
            steps{
                sh 'echo "image docker"'
                sh 'mvn compile'
            }
       }
    }
} 
