pipeline{
    agent none
    stages {

		stage('Clean') {
			agent {
                label 'linux'
            }
			steps {
				echo '****************** $$$$$$$$$$ ****************** '
				sh 'rm -rf target/ 2>/dev/null'
				sh 'sudo rm -rf /var/lib/tomcat8/webapps/springproject* 2>/dev/null'
				echo '****************** $$$$$$$$$$ ****************** '
			}
		}
	    
		stage("Initialize") {
            agent {
                docker 'maven:3.5-alpine'
            }
            stages {
				stage('Checkout') {
					steps {
						git 'http://192.168.1.10/gitlab/springproject.git'
					}
				}
				stage('Compile') {
					steps {
						sh 'mvn clean compile'
					}
				}
				stage('Test') {
					steps {
						sh 'mvn test'
					}
				}
				stage('Build') {
					steps {
						sh 'mvn package'
						archiveArtifacts artifacts: 'target/*.war', fingerprint: true
					}
				}
            }
        }
		
		stage('Deploy') {
			agent {
                label 'linux'
            }
			steps {
				input 'Approval required for Deployment. Proceed?!'
				echo 'Deploying...'
				sh 'sudo cp -rf target/*.war /var/lib/tomcat8/webapps/'
				echo '****************** $$$$$$$$$$ ****************** '
				sh 'ls target/'
				sh 'ls /var/lib/tomcat8/webapps/'
				echo '****************** $$$$$$$$$$ ****************** '
			}
		}
    }
}