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

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=retailkart -Dsonar.projectName=retailkart -Dsonar.host.url=http://172.17.0.1:9000 -Dsonar.token=sqp_fb241ab77635e250deb6daa83cb4e7dcc6d0839e'
                }
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
