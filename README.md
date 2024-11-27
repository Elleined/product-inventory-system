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
docker run -itd --rm -p 8084:8084 --network pis-network --env-file ./environments/prod.env --name pis elleined/pis:latest
```

# Access API Endpoints
[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/26932885-c9e03e71-e43d-4b94-a1a7-4112f3cf265c?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D26932885-c9e03e71-e43d-4b94-a1a7-4112f3cf265c%26entityType%3Dcollection%26workspaceId%3Dc9f39f68-b16b-441e-b666-de275a8908b0)