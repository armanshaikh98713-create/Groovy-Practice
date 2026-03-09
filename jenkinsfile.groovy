pipeline {
    agent any

    environment {
        NAME = "Arman"
        COURSE = "DevOps"
        FIELD = "IT"
        HOME = "/tmp/"
        college = "sahyog"
    }

    stages {
        stage('Print Variables') {
            steps {
                echo "My name is ${NAME}"
                echo "I am learning ${COURSE}"
                echo "My Field is ${FIELD}"
            }
        }
        stage('Listing Directory') {
            steps{
                sh 'ls ${HOME}'
                echo "my college is ${college}"
            }
            
        }
         stage('Pulling Code') {
            steps{
                git branch: 'main', url: 'https://github.com/armanshaikh98713-create/university-website.git'
                //DEVELOPER KA CODE
                // JENKINS ROOT DIRECTORY IS /var/lib/jenkins/workspace/<PIPE-NAME>/
            }

            stage('NGINX Server'){
                steps{
                    sshagent(['nginx']) {
                        "ssh -o StrictHostKeyChecking=no ubuntu@13.235.133.31 'ls' "
                    }
                }
            }
            
        }
    }
}