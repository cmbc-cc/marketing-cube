pipeline {

    agent any

    stages {
        stage('Build') {
            steps {
                //run your build
                sh '/usr/local/bin/mvn clean verify'
            }
            post {
                always {
                    //generate cucumber reports
                    cucumber '**/*.json'
                }
            }
        }
    }
}