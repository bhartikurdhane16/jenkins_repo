pipeline{
    anent any{
        stages{
            stage ('pull') {
                steps {
                    echo 'pull successed'
                } 
            }

            stage ('build') {
                step {
                    echo 'build success'
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