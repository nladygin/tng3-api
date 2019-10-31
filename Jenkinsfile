node {
    
    stage('Update') {
            gitResult = checkout([$class: 'GitSCM', 
                                branches: [[name: '*/master']], 
                                doGenerateSubmoduleConfigurations: false, 
                                extensions: [[$class: 'WipeWorkspace']], 
                                submoduleCfg: [], 
                                userRemoteConfigs: [[url: 'https://github.com/nladygin/tng3-api.git']]
                        ])
    }
    
    stage('Test') {
        timeoutFlag = false
        try {
            timeout(time: 30, unit: 'MINUTES') {
                bat 'mvn clean test'
            }
        }
        catch (org.jenkinsci.plugins.workflow.steps.FlowInterruptedException err) {
                echo 'TIMEOUT!!!'
                timeoutFlag = true
//                throw err
        }
        finally {
            testResult = junit 'target/surefire-reports/*.xml'
        }
    }
   
    parallel (
        report: {
            stage('Report') {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        },
        notification: {
            stage('Notification') {
                mail to:"nladygin@hrsinternational.com", 
                subject:"${currentBuild.fullDisplayName}: ${currentBuild.currentResult}", 
                body: "Build number: #${env.BUILD_NUMBER}\nBuild status: ${currentBuild.currentResult} (Timeout: ${timeoutFlag})\nBranch name: ${gitResult.GIT_BRANCH}\nResult summary: Total: ${testResult.getTotalCount()} / Passed: ${testResult.getPassCount()} / Failed: ${testResult.getFailCount()} / Skiped: ${testResult.getSkipCount()}\nJob total time: ${currentBuild.durationString}\nBuild URL: ${BUILD_URL}"
            }
        }, failFast: false
    )

}
