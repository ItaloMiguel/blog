mvn clean package compile
java -Dspring.profiles.active=test -jar ./target/site.jar