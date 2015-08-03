#/bin/bash
#by zhangtaichao
#在docker环境下
#部署/deploy/edumgmt.war
export tomcat=/root/apache-tomcat-8.0.22
sh $tomcat/bin/shutdown.sh
rm -rf $tomcat/webapps/edumgmt*
cp /deploy/edumgmt.war $tomcat/webapps/edumgmt.war
sh $tomcat/bin/startup.sh