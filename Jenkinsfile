pipeline {

agent any

environment {

RUNNER_IMAGE =
'deepakbatra80/grade-runner:v1'

REPORT_DIR =
"${WORKSPACE}/reports"

}

stages {

stage('Checkout') {

steps {

checkout scm

}

}

stage('Pull Image') {

steps {

sh 'docker pull $RUNNER_IMAGE'

}

}

stage('Run Tests') {

steps {

sh '''
mkdir -p $REPORT_DIR

docker run --rm \
-v $WORKSPACE:/app \
-v $REPORT_DIR:/app/target/surefire-reports \
-w /app \
$RUNNER_IMAGE mvn test
'''

}

}

stage('Publish Results') {

steps {

junit '**/reports/*.xml'

}

}

}

post {

always {

archiveArtifacts(
artifacts:
'reports/**'
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