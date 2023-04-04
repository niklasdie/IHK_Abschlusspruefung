#!/bin/sh

BASEDIR=$(dirname "$0")

java -jar $BASEDIR/.program/gro_pro.jar "$@"