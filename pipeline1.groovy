pipeline{
    anent any{
        stages{
            stage ('pull') {
                steps {
                    echo 'pull successed'
                } 
            }

            stage ()

        }
    }
}

stages {
        stage('pull') {
            steps {
                echo 'pull successed'
            }
        }