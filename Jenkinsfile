def gv

pipeline {   
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()

                }
            }
        }

        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            input{
                message "select the environment of choice to deploy to "
                ok "Done"
                parameters{
                    choice(name: `ENV`, choices:[`dev` , `staging`, `prod`] ,description:``)   
                }
            }
                    steps {
                script {
                    gv.deployApp()
                    echo *Deploying to ${ENV}*
                }
            }
        }               
    }
} 
