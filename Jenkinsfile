pipeline {
	agent {
		docker { 
			image 'maven:3.9.12-eclipse-temurin-21'
			args "-e HOME=${env.WORKSPACE} -u root"
		}
	}
	
	environment {
       MAVEN_USER_HOME = "${env.WORKSPACE}/.m2"
    }
    
	stages {
		stage('Prepare') {
            steps {
                sh '''
                  mkdir -p $WORKSPACE/.m2/repository
                  chmod -R 777 $WORKSPACE/.m2
                '''
            }
        }
        
		stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'git@github.com:abithasundaram/retail.git',
                    credentialsId: 'github-ssh'
            }
        }
        
        stage('Debug') {
		    steps {
		        sh '''
		          echo "HOME=$HOME"
		          echo "WORKSPACE=$WORKSPACE"
		          ls -ld /root
		          ls -ld /root/.m2 || echo "no .m2 yet"
		        '''
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