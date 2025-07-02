// seed.Jenkinsfile

@Library('pipeline-utility-steps') _

pipeline {
    agent any

    environment {
        CONFIG_FILE = 'config.yaml'
        JOB_TEMPLATE = 'job.tpl.groovy'
    }

    stages {
        stage('Load config') {
            steps {
                script {
                    def configText = readFile(env.CONFIG_FILE)
                    def config = readYaml text: configText
                    def projects = config['projects'] ?: [:]

                    projects.each { name, project ->
                        folder(name)

                        if (project['pipe']) {
                            def jobScript = libraryResource(env.JOB_TEMPLATE)
                            def jobDef = jobScript.replaceAll('\\{\\{project_name\\}\\}', name)
                            job(name) {
                                definition {
                                    cps {
                                        script(jobDef)
                                        sandbox()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}