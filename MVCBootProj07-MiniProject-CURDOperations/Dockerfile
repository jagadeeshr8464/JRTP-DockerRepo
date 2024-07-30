FROM  openjdk:17
EXPOSE  4041
COPY   target/sb-mysql-app.war    sb-mysql-app.war
ENTRYPOINT  ["java","-jar","/sb-mysql-app.war"]