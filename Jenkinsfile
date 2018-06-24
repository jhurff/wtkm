node {

   // Mark the code checkout 'stage'....
   stage 'checkout'

   // Get some code from a GitHub repository
   git url: 'https://github.com/jhurff/wtkm'
   sh 'git clean -fdx; sleep 4;'

   // Get the maven tool.
   def mvnHome = tool 'mvn'
   def dockerHome = tool 'docker'

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

      stage 'containerize wtkm-searchindexer'
      sh "${dockerHome}/bin/docker ;"

   }

}
