
import groovy.json.JsonSlurper

def call(prs) {
    def closedPRs = new JsonSlurper().parseText(prs).collect { pr ->
        return pr.state == 'closed'
    }
    closedPRs
}
