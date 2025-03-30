stages {
        stage('Checkout Terraform Scripts from GitLab') {
            steps {
                git branch: 'main', 
                     
                    url: 'https://gitlab.com/your-group/terraform-aws.git'
            }
        }

        stage('Install Terraform') {
            steps {
                sh '''
                sudo apt update && sudo apt install -y terraform
                terraform --version
                '''
            }
        }

        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh 'terraform plan -out=tfplan'
            }
        }

        stage('Manual Approval') {
            steps {
                input message: "Apply Terraform changes?", ok: "Deploy"
            }
        }

        stage('Terraform Apply') {
            steps {
                sh 'terraform apply -auto-approve tfplan'
            }
        }
    }  