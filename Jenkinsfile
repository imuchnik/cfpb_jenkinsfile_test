
@Library('prUtils') _
pipeline {
    agent any


    stages {
        stage('Init') {
            steps {
                script {
                    // Replace all special characters with '-'
                    String stackBaseName = dockerStack.sanitizeStackName(env.JOB_BASE_NAME)
                    env.IMAGE_TAG="${stackBaseName}-${BUILD_NUMBER}"
                }
                sh 'echo ${env.JOB_BASE_NAME}'
                sh 'env | sort'
            }
        }
        stage('Original') {
            steps {
                library 'prUtils'

                script {

                    PR = sh(
                            script: "curl https://api.github.com/repos/imuchnik/cfpb_jenkinsfile_test/pulls/${env.CHANGE_ID} | jq .state",
                            returnStdout: true
                    )
                    PR_List = sh(
                            script: "curl https://api.github.com/repos/imuchnik/cfpb_jenkinsfile_test/pulls?state=closed | jq  -c -r  '.[] | .number' ",
                            returnStdout: true
                    ).trim().split('\n')[0]
                }
                    print("${PR_List}")
              }
          }
      }
  }

