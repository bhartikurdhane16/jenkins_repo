pipeline{
    anent any{
        stages{
            stage ('pull') {
                steps {
                    echo 'pull successed'
                } 
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