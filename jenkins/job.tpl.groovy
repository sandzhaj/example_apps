pipelineJob('${folder}/${jobName}') {
    definition {
        cps {
            script("""
                pipeline {
                    agent any
                    stages {
                        stage('Build') {
                            steps {
                                echo 'Building ${jobName}'
                            }
                        }
                    }
                }
            """.stripIndent())
            sandbox()
        }
    }
}