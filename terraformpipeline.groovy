pipeline {
    agent any

    environment {
        AWS_REGION = "us-east-1"
    }

    stages {
        stage('Assume IAM Role') {
            steps {
                withCredentials([string(credentialsId: 'aws-role-arn', variable: 'ROLE_ARN')]) {
                    sh '''
                    echo "Assuming IAM Role..."
                    CREDENTIALS=$(aws sts assume-role --role-arn $ROLE_ARN --role-session-name JenkinsSession)
                    export AWS_ACCESS_KEY_ID=$(echo $CREDENTIALS | jq -r '.Credentials.AccessKeyId')
                    export AWS_SECRET_ACCESS_KEY=$(echo $CREDENTIALS | jq -r '.Credentials.SecretAccessKey')
                    export AWS_SESSION_TOKEN=$(echo $CREDENTIALS | jq -r '.Credentials.SessionToken')
                    '''
                }
            }
        }

        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Apply') {
            steps {
                sh 'terraform apply -auto-approve'
            }
        }
    }
}

       