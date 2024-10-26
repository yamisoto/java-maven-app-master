#!/user/bin/env groovy
@Library('jenkins-shared-lib-1') _

def gv

pipeline {
    agent any
    tools {
        maven 'Maven' // Ensure 'Maven' is correctly configured in Jenkins Tools
    }
    stages {
        stage("init") {
            steps {
                script {
                    // Load external script with utility methods
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    // Uncomment the following line if `buildJar` is in `script.groovy`
                    // gv.buildJar()
                    buildJar() // Comment this if `buildJar` is only in `script.groovy`
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    // Call buildImage directly from the shared library or gv if in script.groovy
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
