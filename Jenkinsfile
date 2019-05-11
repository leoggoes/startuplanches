pipeline {
    agent none
    stages {
        stage('Build') {
			agent{
				docker {
					image 'maven:latest'
					args '-v /root/.m2:/root/.m2'
				}
			}
			when{
				not{
					branch 'prod'
				}
			}
            steps {				
                //sh './scripts/build.sh'
				sh 'mvn -B -DskipTests clean compile'
            }
        }
        stage('Test') {
			agent{
				docker {
					image 'maven:latest'
					args '-v /root/.m2:/root/.m2'
				}
			}
			when{
				not{
					branch 'prod'
				}
			}
            steps {
                //sh './scripts/test.sh'
				sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }		
		stage('Package') {
			agent{
				docker {
					image 'maven:latest'
					args '-v /root/.m2:/root/.m2'
				}
			}
			when{
				branch 'prod'
			}
			steps {
				//sh './scripts/package.sh'
				sh 'mvn clean package'
			}            
		}
		stage('Deploy') {
			agent{
				label 'master'
			}
			when{
				branch 'prod'
			}
			steps {
				//sh './scripts/deploy.sh'				
				sh 'docker stop startuplanches || exit 0'
				sh 'docker run --rm -d --name startuplanches leoggoes/startuplanches:latest'
				sh 'docker network connect --ip 172.20.0.100 networklanches startuplanches'
			}
		}			
    }
}