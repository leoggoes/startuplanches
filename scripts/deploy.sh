#!/usr/bin/env bash
set -x
set -e
echo 'Deploy Start'
mvn deploy
echo 'Deploy End'