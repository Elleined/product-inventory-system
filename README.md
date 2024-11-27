# product-inventory-system

# Run this project using Docker
- Go to the root project folder and run these commands.
1. Create a docker network
```
docker network create pis-network
```

2. Run MySQL docker container
```
docker run -itd --rm -p 3307:3306 --network pis-network --name mysql_server -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=pis_db mysql:8.0.32
```

3. Run Product Inventory System
```
docker run -itd --rm -p 8084:8084 --network pis-network --env-file prod.env --name pis elleined/pis:latest
```