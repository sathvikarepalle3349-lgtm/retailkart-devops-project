pipeline {
    agent any

    stages {

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/sathvikarepalle3349-lgtm/retailkart-devops-project.git'
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t retailkart-app .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker stop retailkart-container || true'
                sh 'docker rm retailkart-container || true'
            }
        }

        stage('Run New Container') {
            steps {
                sh 'docker run -d -p 8081:8081 --name retailkart-container retailkart-app'
            }
        }

    }
}
