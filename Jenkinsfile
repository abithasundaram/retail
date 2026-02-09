pipeline {
	agent {
		docker { image 'maven:3.9.12-eclipse-temurin-21'
		args '-v $HOME/.ssh:/root/.ssh:ro' }
	}
	stages {
		stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'git@github.com:abithasundaram/retail.git',
                    credentialsId: 'github-ssh'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
	}
	post {
        success {
            echo 'Build Successful!'
        }

        failure {
            echo 'Build Failed!'
        }
    }
}