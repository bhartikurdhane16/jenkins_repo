pipeline {
    agent any

    environment {
        AWS_REGION = "us-east-1"  // Change to your region
        AWS_CREDENTIALS_ID = "aws-credentials"  // Set up in Jenkins credentials
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo.git'  // Replace with your repo
            }
        }

        stage('Install Terraform') {
            steps {
                sh """
                if ! command -v terraform &> /dev/null; then
                    echo 'Installing Terraform...'
                    wget https://releases.hashicorp.com/terraform/1.6.0/terraform_1.6.0_linux_amd64.zip
                    unzip terraform_1.6.0_linux_amd64.zip
                    sudo mv terraform /usr/local/bin/
                fi
                terraform -version
                """
            }
        }

        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Validate') {
            steps {
                sh 'terraform validate'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh 'terraform plan -out=tfplan'
            }
        }

        stage('Manual Approval') {
            steps {
                input message: "Do you want to apply Terraform changes?", ok: "Apply"
            }
        }

        stage('Terraform Apply') {
            steps {
                sh 'terraform apply -auto-approve tfplan'
            }
        }
    }

    post {
        success {
            echo 'Terraform deployment completed successfully!'
        }
        failure {
            echo 'Terraform deployment failed. Check logs for errors.'
        }
    }
}
