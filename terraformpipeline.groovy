
pipeline {
    agent any
    stages {
        stage('Checkout Terraform Scripts from GitLab') {
            steps {
                script {
                    git branch: 'main', url: 'https://gitlab.com/bhartikurdhane16/terraform-project-01.git'
                }
            }
        }

        stage('Terraform Init') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        sh 'terraform init'
                    }
                }
            }
        }

        stage('Terraform Plan') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        sh 'terraform plan -out=tfplan'
                    }
                }
            }
        }

        stage('Manual Approval') {
            steps {
                input message: "Apply Terraform changes?", ok: "Deploy"
            }
        }

        stage('Terraform Apply') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        sh 'terraform apply tfplan'
                    }
                }
            }
        }
    }
}
