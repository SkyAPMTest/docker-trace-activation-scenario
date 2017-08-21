#!/usr/bin/env bash

PRG="$0"
PRGDIR=`dirname "$PRG"`
[ -z "$TRACE_SCENARIO_HOME" ] && TRACE_SCENARIO_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`

CLASSPATH="$TRACE_SCENARIO_HOME/config:$CLASSPATH"
for i in "$TRACE_SCENARIO_HOME"/libs/*.jar
do
    CLASSPATH="$i:$CLASSPATH"
done

export AGENT_FILE_PATH=/usr/local/trace-activation-case/agent
if [ -f "${AGENT_FILE_PATH}/skywalking-agent.jar" ]; then
    TRACE_ACTIVATION_OPTS="$CATALINA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -javaagent:${AGENT_FILE_PATH}/skywalking-agent.jar -DconfigPath=/usr/local/trace-activation-case/agent-config"
fi

java $TRACE_ACTIVATION_OPTS -classpath $CLASSPATH org.skywalking.apm.testcase.trace.annotation.Main
