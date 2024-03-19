pipeline 
{
    agent any
    
    tools{
        maven 'maven'
        }

    stages 
    {
        stage('Build') 
        {
            steps
            {
                  echo("build is ready")
            }
        }
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
        
          
        stage('Regression Automation Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/chhotu93/dockerTaygo.git'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml"
                    
                }
            }
        }
                
        stage("Deploy to Stage"){
            steps{
                echo("deploy to Stage")
            }
        }
        
        stage('Sanity Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/chhotu93/dockerTaygo.git'
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_sanity.xml"
                    
                }
            }
        }
        
        
        
        stage('Publish sanity Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'reports', 
                                  reportFiles: 'TestExecutionReport.html', 
                                  reportName: 'HTML Sanity Extent Report', 
                                  reportTitles: ''])
            }
        }
        
          stage('Publish Allure Results') {
                    steps {
                        script {
                            // Publish Allure results to Jenkins
                            allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                            ])
                        }
                    }
                }
        stage("Deploy to PROD"){
            steps{
                echo("deploy to PROD")
            }
        }
        
        
    }
}