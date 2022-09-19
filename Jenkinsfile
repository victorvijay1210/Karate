pipeline {

    agent any

    stages {
        stage('Run Test') {
            steps {
            bat label: '', script:'mvn clean verify'
            }
            
        post {
    always {
   junit '**/surefire-reports/*.xml'
    }
    }

            

       
        }
    }
    }
