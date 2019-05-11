#!/usr/bin/env bash
set -x
set -e
echo 'Build Start'
mvn -B -DskipTests clean compile
echo 'Build End'