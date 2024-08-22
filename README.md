
# Warehouse service

## REST API

|    Endpoint	     | Method |   Req. body   | Status |     Resp. body     | Description    		   	                 |
|:----------------:|:------:|:-------------:|:------:|:------------------:|:--------------------------------------|
| `/load/articles` | `POST` |   Article[]   |  200   |     Article[]      | Load articles into the system.        |
|                  |        |               |  404   |                    | Bad request (TODO...)                 |
| `/load/products` | `POST` |   Product[]   |  200   |     Product[]      | Load products into the system.        |
|                  |        |               |  404   |                    | Bad request (TODO...)                 |
|   `/products`    | `GET`  |               |  200   | AvailableProduct[] | List products with quantity in stock. |
|     `/sell`      | `POST` | SalesProduct  |  200   |                    | Update stock of articles for product. |
|                  |        |               |  404   |                    | Bad request (TODO...)                 |

## Helpful steps to get something running

### Gradle...

### Docker...

### Example of how to load the files with cURL: 
```bash
# Should work with Terminal for MacOs, Linux, WSL or Git for Windows
curl --header "Content-Type: application/json" --data "$(cat inventory.json)" http://localhost:8080/load/articles
curl --header "Content-Type: application/json" --data "$(cat products.json)" http://localhost:8080/load/products
```

## Notes / Assumptions
* Adding missing argument price to "Dinning Table" in products.json. Normal procedure would be to inform project and ask for a price.

