#!/bin/sh
mvn eclipse:eclipse
sed -i '/JRE_CONTAINER/d' app/.classpath device-tests/.classpath
