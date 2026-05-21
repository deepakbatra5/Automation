pipeline {

agent any

environment {

REPORT_DIR = "${WORKSPACE}/target/surefire-reports"

}

stages {

stage('Checkout') {

steps {

checkout scm

}

}

stage('Run Tests') {

steps {

	sh 'mvn test'

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