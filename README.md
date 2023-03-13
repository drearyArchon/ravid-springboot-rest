# ravid-springboot-rest
A SpringBoot REST API that serves products. The API retrieves data from a MongoDB Database.

To use this API, run the springboot-rest-asyx-1.0.1-SNAPSHOT.jar using the command ```java -jar springboot-rest-asyx-1.0.1-SNAPSHOT.jar```. The API runs on port 7000.

```localhost:7000/filter/price/{initial_value}/{final_value}``` runs a GET Request and returns with a list of Products whose price is between initial_value and final_value. Returns an error if no Products are found.

```localhost:7000/sort/price``` runs a GET Request and returns a list of Product which is sorted using their prices in ascending value. Returns an error if no Products are found.

```localhost:7000/generate/{number}``` runs a request that populates the database with ```{number}``` additional random products. Can only create up to 100 products at a time.

```localhost:7000/barcode/{code_string}``` runs a request that returns the product with the barcode ```{code_string}```. Returns an error if no Product is found.

```localhost:7000/delete/{code_string}``` runs a request that deletes the product with the barcode ```{code_string}```. Returns an error if no Product is found to be deleted.
