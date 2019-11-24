#!/usr/bin/env bash

case $1 in
	start)
		sudo nohup java -jar leyou-user-service.jar >/dev/null 2>&1 &
		echo "user-service启动了..."
		sleep 1
	;;
	stop)
		killall leyou-user-service.jar
		echo "user-service关闭了..."
		sleep 1
	;;
	restart)
		killall leyou-user-service.jar
		sleep 1
		sudo nohup java -jar leyou-user-service.jar  >/dev/null 2>&1 &
		echo "user-service重启了..."
		sleep 1
	;;
	*)
		echo "$0 {start|stop|restart}"
		exit 4
	;;
esac
