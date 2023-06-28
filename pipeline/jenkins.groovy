pipeline {
    agent any
    parameters {
        choice(name: 'OS', choices: ['linux', 'darwin', 'windows'], description: 'Pick target OS')
        choice(name: 'ARCH', choices: ['arm64', 'amd64'], description: 'Pick target architecture')
    }
    environment {
        REPO = 'https://github.com/daria-hrebonkina/kbot'
        BRANCH = 'main'
    }
    stages {
        stage('clone') {
            steps {
                echo 'Clone repository'
                git branch: "${BRANCH}", url: "${REPO}"
            } 
        }

        stage('test') {
            steps {
                echo 'Test execution started'
                sh 'make test'
            }
        }

        stage('build') {
            steps {
                echo echo "Build for platform ${params.OS}, architecture ${params.ARCH}"
                sh "make build TARGET_OS=${params.OS} TARGET_ARCH=${params.ARCH}"
            }
        }

        stage('image') {
            steps {
                echo echo "Create an image of build"
                sh "make image TARGET_OS=${params.OS} TARGET_ARCH=${params.ARCH}"
            }
        }

        stage('push') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub') {
                        sh 'make push TARGET_OS=${params.OS} TARGET_ARCH=${params.ARCH}'
                    }
                }
            }
        }
    }
}