#!groovy
pipeline{
    agent {
        docker {image 'maven: puzzle-image'}
    }
    stages{
       stage('Build'){
            steps{
                sh 'echo "image docker"'
            }
       }
    }
} 
