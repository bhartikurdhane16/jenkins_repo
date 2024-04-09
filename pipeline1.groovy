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
            stage ('test'){
                step{
                    echo 'test success'
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