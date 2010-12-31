#!/bin/sh
version=1.1
tempdir=`mktemp -d`
if [ ! -d "$tempdir" ]; then
	echo "Error: Couldn't create temporary directory"
	exit 1
fi
cd "$tempdir" || exit 1
wget http://hamcrest.googlecode.com/files/hamcrest-core-$version.jar || exit 1
wget http://hamcrest.googlecode.com/files/hamcrest-library-$version.jar || exit 1
unzip -o hamcrest-core-$version.jar || exit 1
unzip -o hamcrest-library-$version.jar || exit 1
zip -r9 hamcrest-android-$version.jar org
mvn install:install-file \
	-Dfile=hamcrest-android-$version.jar \
	-DgroupId=org.hamcrest \
	-DartifactId=hamcrest-android \
	-Dpackaging=jar \
	-Dversion=$version || exit 1

