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
   cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: 'target/cucumber.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1}
   
    }
    }

            

       
        }
    }
    
