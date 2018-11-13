#基础镜像
FROM tomcat:7.0.86

#作者
MAINTAINER jackchow "jack_chow621@sina.com"


#运行安装telnet和nc
RUN apt-get install -y telnet nc; exit 0

#
VOLUME ["/opt/tomcat"]

#TOMCAT环境变量
ENV CATALINA_BASE: /usr/local/tomcat \
    CATALINA_HOME: /usr/local/tomcat \
    CATALINA_TMPDIR: /usr/local/tomcat/temp \
    JRE_HOME: /usr
    
# 镜像暴露8080端口； 
EXPOSE 8080 

#启动入口
ENTRYPOINT ["catalina.sh","run"]

#健康检查
# HEALTHCHECK --interval=10s --timeout=3s \
#   CMD nc -z localhost 5198 >/dev/null || exit 1

#拷贝war包到tomcat
COPY target/SBM.war ${CATALINA_HOME}/webapps/
