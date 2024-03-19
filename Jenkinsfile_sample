pipeline{
    
    agent any
    
    stages{
        
        stage("Build"){
            steps{
                echo("build the project")
            }
        }
        
        stage("Run UTs"){
            steps{
                echo("Run unit tests")
            }
        }
        
        stage("Deploy to Dev"){
            steps{
                echo("Deploying to Dev environment")
            }
        }
        
        stage("Deploy to QA"){
            steps{
                echo("Deploying to QA environment")
            }
        }
        
         stage("Run regression automation test cases"){
            steps{
                echo("Run regression automation test cases")
            }
        }
        
         stage("Deploy to Stage"){
            steps{
                echo("Deploying to stage environment")
            }
        }
        
        stage("Run Sanity TCs1"){
            steps{
                echo("Running sanity test case suit1")
            }
        }
        
        stage("Run Sanity TCs2"){
            steps{
                echo("Running sanity test case suit2")
            }
        }
        stage("Go Live"){
            steps{
                echo("Deploying code on production")
            }
        }
    }
    
    
}