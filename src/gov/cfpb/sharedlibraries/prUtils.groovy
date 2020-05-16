#!/usr/bin/env groovy
package gov.cfpb.sharedlibraries

import groovy.json.JsonSlurper

class prUtils {
    def filterClosedPRs(prs) {
        def closedPRs = new JsonSlurper().parseText(prs).collect { pr ->
            return pr.state == 'closed'
        }
        closedPRs
    }
}

