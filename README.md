
# Warehouse service

## REST API

|    Endpoint	     | Method |   Req. body   | Status |   Resp. body   | Description    		    	                |
|:----------------:|:------:|:-------------:|:------:|:--------------:|:--------------------------------------|
| `/load/articles` | `POST` |   Article[]   |  200   |   Article[]    | Load articles into the system.        |
|                  |        |               |  404   |                | Bad request (TODO...)                 |
| `/load/products` | `POST` |   Product[]   |  200   |   Product[]    | Load products into the system.        |
|                  |        |               |  404   |                | Bad request (TODO...)                 |
|   `/products`    | `GET`  |               |  200   | SalesProduct[] | List products with quantity in stock. |
|     `/sell`      | `POST` | SalesProduct  |  200   |                | Update stock of articles for product. |
|                  |        |               |  404   |                | Bad request (TODO...)                 |

## Helpful steps to get something running

### Gradle...

### Docker...

### Example of how to load the files with cURL: 
```bash
# Should work with Terminal for MacOs, Linux, WSL or Git for Windows
curl --header "Content-Type: application/json" --data "$(cat inventory.json)" http://localhost:8080/load/articles
curl --header "Content-Type: application/json" --data "$(cat products.json)" http://localhost:8080/load/products
```

### Example of how to call endpoints with cURL: 

```bash
curl --header "Content-Type: application/json" http://localhost:8080/products
```

## Notes / Assumptions
* Adding missing price to "Dinning Table" in products.json. Normal procedure would be to inform project and ask 
  for a price.
* Shouldn't have used quantity for stock and amount_of internally. Possible bad readability and maintainability 
  in some of the available prodoct logic. 
