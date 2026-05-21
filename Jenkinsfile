pipeline {

agent any

stages {

stage('Checkout') {

steps {

checkout scm

}

}

stage('Run Tests') {

steps {

	script {
		if (isUnix()) {
			sh 'bash ./mvnw test'
		} else {
			bat 'mvnw.cmd test'
		}
	}

}

}

stage('Publish Results') {

steps {

	junit 'target/surefire-reports/*.xml'

}

}

}

post {

always {

archiveArtifacts(
artifacts:
'target/surefire-reports/**'
)

}

success {

echo 'BUILD PASSED'

}

failure {

echo 'BUILD FAILED'

}

}

}