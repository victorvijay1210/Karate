pipeline {

    agent any

    stages {
        stage('Run Test') {
            steps {
            bat label: '', script:'mvn clean test'
            }
            
            
      
    }


 stage('Generate HTML report') {
        cucumber buildStatus: 'UNSTABLE',
                reportTitle: 'My report',
                fileIncludePattern: '**/*.json',
                trendsLimit: 10,
                classifications: [
                    [
                        'key': 'Browser',
                        'value': 'Firefox'
                    ]
                ]
    }
    
   

       
        }
    }
    