FROM tomcat:9-jdk17-corretto

COPY ./target/AliceGame-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/