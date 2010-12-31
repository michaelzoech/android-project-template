#!/bin/sh
if [ ! -d "$ANDROID_HOME" ]; then
	echo ANDROID_HOME var not set
	exit 1
fi
tempdir=`mktemp -d`
if [ ! -d "$tempdir" ]; then
	echo "Error: Couldn't create temp directory"
	exit 1
fi
cd "$tempdir" || exit 1
git clone https://github.com/mosabua/maven-android-sdk-deployer.git || exit 1
cd maven-android-sdk-deployer || exit 1
mvn install -P 2.1 || exit 1
mvn install -P 2.2 || exit 1
mvn install -P 2.3 || exit 1
