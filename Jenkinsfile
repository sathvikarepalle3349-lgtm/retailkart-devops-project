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
                sh 'docker build -t retailkart-app:v3 .'
            }
        }

        stage('Load Image into Minikube') {
            steps {
                sh 'minikube image load retailkart-app:v3'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl set image deployment/retailkart-deployment retailkart-container=retailkart-app:v3'
            }
        }

        stage('Verify Deployment') {
            steps {
                sh 'kubectl get pods'
            }
        }
    }
}
