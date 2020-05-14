@Library('prUtils') _
pipeline {
    agent any
    environment {
        TEST_VAR = sh(
                returnStdout: true,
                script: "echo 'ORIGINAL'"
        )
    }

    stages {
        stage('Original') {
            steps {
                library 'prUtils'

                script {

                    PR = sh(
                            script: "curl https://api.github.com/repos/imuchnik/cfpb_jenkinsfile_test/pulls/${env.CHANGE_ID} | jq .state",
                            returnStdout: true
                    )
                    PR_List = sh(
                            script: "curl https://api.github.com/repos/imuchnik/cfpb_jenkinsfile_test/pulls?state=closed | jq '.[] | .number' ",
                            returnStdout: true
                    ).trim()
//                    prUtils $PR_List
                }
                sh "echo the PR is ${PR}"
                sh "echo ******************************"
                sh "echo the closed PR is ${PR_List}"

            }
        }
        stage('Env modification') {
            steps {
                withEnv(["TEST_VAR=${TEST_VAR}"]) {
                    sh 'echo PR status is $PR'
                    sh 'env|sort'
                }
            }
        }
    }
}
