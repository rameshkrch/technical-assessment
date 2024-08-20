



Example of how to load the files with cURL:
$ curl --header "Content-Type: application/json" --data "$(cat inventory.json)" http://localhost:8080/articles
$ curl --header "Content-Type: application/json" --data "$(cat products.json)" http://localhost:8080/products


