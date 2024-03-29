FROM java:latest

#设置时区为上海
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./springboot/target/*.jar /tmp

RUN cp -f ./tmp/*.jar /app.jar

CMD echo "The SpringBootApplication is starting..." && \
    java -jar /app.jar