
@Library('prUtils') _
pipeline {
    agent any


    stages {
        stage('Init') {
            steps {
                sh 'env | sort'
            }
        }
        stage('Original') {
            steps {
                library 'prUtils'

                script {
//
//                    PR = sh(
//                            script: "curl https://api.github.com/repos/imuchnik/cfpb_jenkinsfile_test/pulls/${env.CHANGE_ID} | jq .state",
//                            returnStdout: true
//                    )
                    PR_List = sh(
                            script: "curl 'https://github.cfpb.gov/api/v3/repos/app-ops/orsee/pulls?state=closed&sort=updated&direction=desc&per_page=20' | jq -c -r  '.[] | .number' ",
                            returnStdout: true
                    ).trim().split('\n')[0]
                }
                    PR_List.each{ pr ->
                        print("PR  number is ${pr}")
                        if (dockerStack.exists("orsee-pr-${pr}")){
                            dockerStack.remove("orsee-pr-${pr}")
                        }

                    }

                dockerStack.
                    print("${PR_List}")
              }
          }
      }
  }

