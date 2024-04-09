pipeline{
    anent any{
        stages{
            stage ('pull') {
                steps {
                    echo 'pull successed'
                } 
            }

            stage ('build') {
                step 
            }

        }
    }
}

stages {
        stage('pull') {
            steps {
                echo 'pull successed'
            }
        }