#!/bin/sh
version=0.9.4
tempdir=`mktemp -d`
if [ ! -d "$tempdir" ]; then
	echo "Error: Cloudn't create temp directory"
	exit 1
fi
cd "$tempdir" || exit 1
wget http://pivotal.github.com/robolectric/downloads/robolectric-$version-all.jar || exit 1
wget http://pivotal.github.com/robolectric/downloads/robolectric-$version-src.jar || exit 1
mvn install:install-file \
	-Dfile=robolectric-$version-all.jar \
	-Dsources=robolectric-$version-src.jar \
	-DgroupId=com.xtremelabs.robolectric \
	-DartifactId=robolectric-all \
	-Dpackaging=jar \
	-Dversion=$version || exit 1

