FROM tomcat:10-jdk11-openjdk

COPY ./target/*.war /usr/local/tomcat/webapps/JEE_Dep_war_exploded

EXPOSE 8080

CMD ["catalina.sh", "run"]