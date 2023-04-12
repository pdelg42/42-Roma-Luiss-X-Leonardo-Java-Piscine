mvn -B archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
mvn compile: for compiler erro change the version in the pom file
mvn test
mvn package: now we can see ${basedir/target}
mvn install: installing in ${user.home}/.m2/repo
