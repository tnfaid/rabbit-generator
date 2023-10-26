#!/bin/bash

cd /home/titik/Documents/Server/simulasiRunningProd/rabbit-generator/src/main/resources

if [ -f rabbit-generator.pid ]
then
    kill `cat rabbit-generator.pid`
    echo "service stop"
        rm -f rabbit-generator.pid
else
        echo "not running ??"
fi
