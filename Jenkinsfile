@Library('prUtils') _
pipeline {
    agent any


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
                            script: "curl https://api.github.com/repos/imuchnik/cfpb_jenkinsfile_test/pulls?state=closed | jq  -c -j  '.[] | .number' ",
                            returnStdout: true
                    ).trim().split(" ")
                    print("${PR_List}")
                }
                sh "echo the PR is ${PR}"
                sh "echo the closed PR is '${PR_List}'"
            }
        }
    }
}
