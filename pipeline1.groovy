pipeline{
    anent any{
        stages{
            stage ('pull') {
                steps {
                    echo 'pull successed'
                } 
            }

            stage ('build')

        }
    }
}

stages {
        stage('pull') {
            steps {
                echo 'pull successed'
            }
        }