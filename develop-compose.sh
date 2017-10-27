#!/usr/bin/env bash
docker-compose 	-f docker-compose.yml \
                -f cassandra/docker-compose.yml  $@
                