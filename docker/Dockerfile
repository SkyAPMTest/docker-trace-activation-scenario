FROM openjdk:8-jdk

ENV COLLECTOR_SERVER=127.0.0.1:12800

ADD trace-activation-case.tar.gz /usr/local/
ADD sky-walking.config /usr/local/trace-activation-case/agent-config/

ADD docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh

EXPOSE 5005
EXPOSE 8080

VOLUME /usr/local/trace-activation-case/agent
ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["/usr/local/trace-activation-case/bin/startUp.sh"]
