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
            stage 9
        }
    }
}

stages {
        stage('pull') {
            steps {
                echo 'pull successed'
            }
        }