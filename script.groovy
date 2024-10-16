
def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'vmcgtlx', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
        sh 'docker build -t vmcgtlx/demo-app:jma-2.0 .'
        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
        sh 'docker push vmcgtlx/demo-app:jma-2.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this

