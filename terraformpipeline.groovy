pipeline{
    agent any
    stages {
        stage('Checkout Terraform Scripts from GitLab') {
            steps {
                git branch: 'main'
                     url: 'https://gitlab.com/bhartikurdhane16/terraform-project-01.git'
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
    }