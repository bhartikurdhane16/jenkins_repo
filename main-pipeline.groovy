pipeline{
    agent any

    stages{
        stage ('pull'){
            steps{
                echo 'pull stage'
            }
        }

        stage ('build'){
            steps{
                echo 'build stage'
            }
        }

        stage ('test'){
            steps{
                echo 'test stage'
            }
        }

        stage ('deploy'){
            steps{
                echo 'deploy stage'
            }
        }
    }




}