#!/bin/bash
cleanerjar=jar-cleaner-all-1.0-SNAPSHOT.jar
tempdir=`mktemp -d`
if [ ! -d "$tempdir" ]; then
	echo "Error: Couldn't create temp directory"
	exit 1
fi
cd "$tempdir" || exit 1
wget --no-check-certificate https://github.com/downloads/crazymaik/android-jar-cleaner/$cleanerjar || exit 1
DIR=~/.m2/repository/android/android
for file in $DIR/*; do
	if [ -d $file ]; then
		rm -f out.jar
		version=`basename $file`
		java -jar $cleanerjar $DIR/$version/android-$version.jar out.jar || exit 1
		mvn install:install-file \
			-Dfile=out.jar \
			-DgroupId=android \
			-DartifactId=android \
			-Dpackaging=jar \
			-Dversion=$version \
			-Dclassifier=clean || exit 1
	fi
done

DIR=~/.m2/repository/com/google/android/maps/maps
for file in $DIR/*; do
	if [ -d $file ]; then
		rm -f out.jar
		version=`basename $file`
		java -jar $cleanerjar $DIR/$version/maps-$version.jar out.jar || exit 1
		mvn install:install-file \
			-Dfile=out.jar \
			-DgroupId=com.google.android.maps \
			-DartifactId=maps \
			-Dpackaging=jar \
			-Dversion=$version \
			-Dclassifier=clean || exit 1
	fi
done
