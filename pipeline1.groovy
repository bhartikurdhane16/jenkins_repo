pipeline{
    agent any

        stages{

            stage ('pull') {
                steps {
                    echo 'pull successed'
                } 
            }

            stage ('build') {
                steps {
                    echo 'build success'
                }
            }
            
            stage ('test'){
                steps{
                    echo 'test success'
                }
            }

            stage ('deploy'){
                step{
                    echo 'deploy success'
                }
            }
        }
        }


