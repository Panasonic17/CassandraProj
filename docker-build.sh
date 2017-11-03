#!/usr/bin/env bash
docker build -t datasource ./dataSource
docker build -t spark ./spark
docker build -t spark ./kafka
