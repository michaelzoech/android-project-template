#!/bin/sh
mvn -Pmaven clean
mvn -Peclipse clean eclipse:clean eclipse:eclipse
sed -i '/JRE_CONTAINER/d' app/.classpath device-tests/.classpath
