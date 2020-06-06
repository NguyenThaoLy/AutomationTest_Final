pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

                    bat 'mvn clean install'

      

            }
        }
    stage ('Test Stage') {

            steps {

                    bat 'mvn test'

            }
        }

    stage('Deploy to Staging'){
        steps {
                echo "Ok"
            }
    }

    stage ('Cucumber Reports') {

        steps {
            cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'

        }

    }

    }

}
