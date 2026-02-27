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
    }
}