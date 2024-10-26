#!/user/bin/env groovy
@Library('jenkins-shared-lib-1') _
import jenkins-shared-lib-1.buildImage

def gv

pipeline {
    agent any
    tools {
        maven 'Maven' // Make sure 'Maven' is correctly configured in Jenkins Tools
    }
    stages {
        stage("init") {
            steps {
                script {
                    // Loading external script for utility methods
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    // If `buildJar` is in `script.groovy`, uncomment the line below:
                    // gv.buildJar()
                    buildJar() // Comment this if `buildJar` is only in `script.groovy`
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    // Use gv.buildImage() if defined in script.groovy
                    // or call directly from shared library as shown here
                    buildImage 'vmcgtlx/demo-app:jma-22.2'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    // Ensure deployApp is defined in script.groovy
                    gv.deployApp()
                }
            }
        }
    }
}
