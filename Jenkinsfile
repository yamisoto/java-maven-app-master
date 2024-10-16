pipeline {
    agent any

    stages {
        stage('Build') {
            when {
                expression {
                    return env.BRANCH_NAME == "jenkins-jobs"
                }
            }
            steps {
                echo 'BUILDING THE APPLICATION'
                // Add build steps here, e.g., run build scripts, compile code, etc.
            }
        }

        stage('Test') {
            steps {
                echo 'testing the application'
                // Add test steps here, e.g., run unit tests, integration tests, etc.
            }
        }

        stage('Deploy') {
            when {
                expression {
                    return env.BRANCH_NAME == "starting-code"
                }
            }
            steps {
                echo 'deploying the application'
                // Add deploy steps here, e.g., deploy to servers, run deploy scripts, etc.
            }
        }
    }
}
