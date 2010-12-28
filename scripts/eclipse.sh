#!/bin/sh
mvn -Pmaven clean || exit 1
mvn -Peclipse clean eclipse:clean eclipse:eclipse || exit 1
sed -i '/JRE_CONTAINER/d' app/.classpath device-tests/.classpath || exit 1
