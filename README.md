# ravid-springboot-rest
A SpringBoot REST API that serves products. The API retrieves data from a MongoDB Database.

To use this API, run the Application and go to localhost:8080. localhst:8080 should show the unsorted database of Products.

localhost:8080/filter/price/{initial_value}/{final_value} runs a GET Request and returns with a list of Products whose price is between initial_value and final_value.

localhost:8080/sort/price runs a GET Request and returns a list of Product which is sorted using their prices in ascending value.

localhost:8080/generate/{number} runs a request that populates the database with {number} additional random products

localhost:8080/barcode/{code_string} runs a request that returns the product with the barcode {code_string}

localhost:8080/delete/{code_string} runs a request that deletes the product with the barcode {code_string}
