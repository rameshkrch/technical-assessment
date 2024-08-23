
# Warehouse service

## REST API

|    Endpoint	     | Method |      Req. body      | Status |   Resp. body   | Description    		    	                |
|:----------------:|:------:|:-------------------:|:------:|:--------------:|:--------------------------------------|
| `/load/articles` | `POST` | LoadArticlesRequest |  200   |   Article[]    | Load articles into the system.        |
|                  |        |                     |  404   |                | Bad request (TODO...)                 |
| `/load/products` | `POST` | LoadProductsRequest |  200   |   Product[]    | Load products into the system.        |
|                  |        |                     |  404   |                | Bad request (TODO...)                 |
|   `/products`    | `GET`  |                     |  200   | SalesProduct[] | List products with quantity in stock. |
|     `/sell`      | `POST` |     SellRequest     |  200   |                | Update stock of articles for product. |
|                  |        |                     |  404   |                | Bad request (TODO...)                 |

## Helpful steps to get something running

### Gradle

| Gradle Command	            | Description                                     |
|:---------------------------|:------------------------------------------------|
| `./gradlew bootRun`        | Run the application.                            |
| `./gradlew build`          | Build the application.                          |
| `./gradlew test`           | Run tests.                                      |
| `./gradlew bootJar`        | Package the application as a JAR.               |
| `./gradlew bootBuildImage` | Package the application as a container image.   |

### Postgres

Run PostgreSQL as a Docker container

```bash
docker run -d \
    --name warehouse \
    -e POSTGRES_USER=user \
    -e POSTGRES_PASSWORD=password \
    -e POSTGRES_DB=warehouse \
    -p 5432:5432 \
    postgres
```

### Docker Compose

```bash
./docker/docker-compose.yml
```

### Example of how to call endpoints with cURL: 

```bash
# Should work with Terminal for MacOs, Linux, WSL or Git for Windows
curl --header "Content-Type: application/json" --data "$(cat inventory.json)" http://localhost:8080/load/articles
curl --header "Content-Type: application/json" --data "$(cat products.json)" http://localhost:8080/load/products
curl --header "Content-Type: application/json" http://localhost:8080/products
curl --header "Content-Type: application/json" http://localhost:8080/actuator/health
curl --header "Content-Type: application/json" http://localhost:8080/actuator/flyway
```

## Notes / Assumptions
* Adding missing price to table in products.json. Normal procedure would be to inform project and ask 
  for a price.
* Shouldn't have used quantity for stock and amount_of internally. Possible bad readability and maintainability 
  in some of the available prodoct logic. 
* Last endpoint /sell not implemented due to time constraint. 
* Open to null pointer att some places when going of script.
* Possible to load inventory several times and get multiples of the same art_id.
* ...

