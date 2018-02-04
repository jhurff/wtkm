node {

   // Mark the code checkout 'stage'....
   stage 'checkout'

   // Get some code from a GitHub repository
   git url: 'https://github.com/jhurff/wtkm'
   sh 'git clean -fdx; sleep 4;'

   // Get the maven tool.
   def mvnHome = tool 'mvn'

   dir ('wtkm-searchindexer') {

      stage 'build wtkm-searchindexer'

      sh 'pwd'

      sh "${mvnHome}/bin/mvn versions:set -DnewVersion=${env.BUILD_NUMBER}"
      sh "${mvnHome}/bin/mvn package"

      stage 'test wtkm-searchindexer'
      parallel 'test': {
        sh "${mvnHome}/bin/mvn test; sleep 2;"
      }, 'verify': {
        sh "${mvnHome}/bin/mvn verify; sleep 3"
      }

      stage 'archive wtkm-searchindexer'
      archive 'target/*.jar'

   }
}

node {
   stage 'deploy Canary'
   sh 'echo "write your deploy code here"; sleep 5;'

   stage 'deploy Production'
   //input 'Proceed?'
   sh 'echo "write your deploy code here"; sleep 6;'
   archive 'target/*.jar'
}
