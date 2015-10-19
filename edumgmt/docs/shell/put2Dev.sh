#!/bin/bash
#将本地jar包传输至远程服务器
export REMOTE=javateam@226.shinc.net:/home/javateam/edumgmt/deploy/
export JARNAME=edumgmt.jar
SAVED="$(pwd -P)"
cd "$(dirname $0)/../.."
LIBPATH="$(pwd -P)/build/libs"
cd $SAVED

echo "scp from ${LIBPATH}/${JARNAME} to $REMOTE"
scp ${LIBPATH}/${JARNAME} $REMOTE
