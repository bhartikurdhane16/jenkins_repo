pipeline{
    agent any

    stages{
        stage ('pull'){
            steps{
                git 'https://github.com/bhartikurdhane16/studentapp.ui.git'
                echo 'pipe'
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