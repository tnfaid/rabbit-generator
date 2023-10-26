#!/bin/bash

cd /home/titik/Documents/Server/simulasiRunningProd/rabbit-generator/src/main/resources/

if [ ! -f genesis_ledger.pid ];then
        java -Dlogging.config=/home/titik/Documents/Server/simulasiRunningProd/rabbit-generator/src/main/resources/log4j2.xml -jar /home/titik/Documents/Server/simulasiRunningProd/rabbit-generator/target/redis-tutorial-0.0.1-SNAPSHOT.jar -Dspring.config.location=/home/titik/Documents/Server/simulasiRunningProd/rabbit-generator/src/main/resources/application.properties -Xss1m -Xms2g -Xmx6g -XX:+UseConcMarkSweepGC -XX:ThreadStackSize=1024> out.txt 2>&1 & echo $! > rabbit_generator.pid;
        sleep 5s;
        echo "success running : `cat rabbit_generator.pid`"
else
        echo "udah jalan ? "
fi
