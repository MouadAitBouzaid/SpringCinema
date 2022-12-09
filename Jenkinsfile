pipeline {
    agent { docker { image 'Apache Maven 3.6.3'} }
    stages{
        stage('log version info'){
            steps{
                sh 'mvn --version'
                sh 'mvn clean install'
            }
        }
    }
}