FROM tomcat:latest

ADD out/artifacts/whereis_war/whereis.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]