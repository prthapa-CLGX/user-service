node {
    try {
        def serviceName = ""
        def version = ""
        stage('SCM Checkout') {
            checkout([$class: 'GitSCM',
               branches: [[name: env.BRANCH_NAME]],
               doGenerateSubmoduleConfigurations: false,
               extensions: [[$class: 'CleanBeforeCheckout']],
               submoduleCfg: [],
               userRemoteConfigs: [[url: 'https://github.com/prthapa-CLGX/user-service.git']]
           ])

        }

        stage('Gradle build') {
            sh('./gradlew -i clean build')
        }

        stage('BuildImage PushToLocalRegistry') {
           sh('./gradlew -i dockerPush')
        }

        stage('CT: Master Test') {
            build job: 'poc-master-test', propagate: true, wait: true
        }
    } catch(e) {
        throw (e)
    } finally {
      stage('Clean Up and Notify') {
           sh('echo cleaning up tasks......')
            version = sh(script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'", returnStdout: true).trim()
            serviceName = sh(script: "./gradlew properties -q | grep \"archivesBaseName:\" | awk '{print \$2}'", returnStdout: true).trim()
            sh "echo If Build Fail: ***** Service: $serviceName Version: $version build was unsuccessful ***** Sending email ............."
           //mail to: "me@testemail.com"
      }
    }
}
