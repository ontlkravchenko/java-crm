FROM tomcat:latest

COPY whereis.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 80

CMD ["catalina.sh", "run"]