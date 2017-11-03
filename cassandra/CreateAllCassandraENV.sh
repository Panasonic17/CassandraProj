 ContainerName=cassandra-1
 docker cp init.sh $ContainerName:init.sh
 docker cp init.sql $ContainerName:init.sql
 winpty docker exec -it $ContainerName bash crateTable.sh
 