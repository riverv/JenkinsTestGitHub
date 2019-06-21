#!groovy
pipeline{
    agent {
        docker {image 'puzzle-image'}
    }
    stages{
       stage('Build'){
            steps{
                sh 'echo "let s build"'
                sh 'mvn compile'
            }
       }
    }
} 
