pipeline{
    anent any{
        stages{
            stage ('pull'){
                steps 
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