 ContainerName=cassandra-1
 docker cp init.sh $ContainerName:init.sh
 docker cp init.sql $ContainerName:init.sql
 docker exec -it $ContainerName bash init.sh
 
