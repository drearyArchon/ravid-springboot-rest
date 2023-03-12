package com.mrv.controller;

import com.mrv.model.ASYXProduct;
import com.mrv.service.ASYXProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class ASYXProductController {

    @Autowired
    private ASYXProductService ASYXProductService;

    @GetMapping("/")
    public ResponseEntity getAllProducts() {
        List<ASYXProduct> productList = ASYXProductService.getAllProduct();
        if (productList.isEmpty()){
            return ResponseEntity.badRequest().body("No Products Found");
        }
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/filter/price/{min_range}/{max_range}")
    public ResponseEntity getAllProductsInRange(@PathVariable("min_range") int min_range, @PathVariable("max_range") int max_range) {
        List<ASYXProduct> productList = ASYXProductService.getProductByPriceRange(min_range, max_range);
        if (productList.isEmpty()){
            return ResponseEntity.badRequest().body("No Products Found");
        }
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/sort/price")
    public ResponseEntity getAllProductsSortPrice() {
        List<ASYXProduct> productList = ASYXProductService.getAllProductSortByPrice();
        if (productList.isEmpty()){
            return ResponseEntity.badRequest().body("No Products Found");
        }
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/barcode/{code}")
    public ResponseEntity getProductByBarcode(@PathVariable("code") String barcode) {
        return ResponseEntity.ok().body(ASYXProductService.getProductByBarcode(barcode));
    }

    @GetMapping("/delete/{code}")
    public ResponseEntity deleteProductByBarcode(@PathVariable("code") String barcode) {
        try {
            ASYXProductService.deleteProduct(barcode);
            return ResponseEntity.ok().body(barcode.concat(" Deleted"));
        } catch (Exception e) {
            return ResponseEntity.ok().body("Barcode Not Found");
        }
    }

    @GetMapping("/generate/{num}")
    public ResponseEntity createProductByBarcode(@PathVariable("num") int number) {
        Random randNumGen = new Random();
        for (int i = 0; i < number; i++) {
            ASYXProductService.createProductWithBarcode(String.valueOf(randNumGen.nextInt(10000000, 90000000)));
        }
        return ResponseEntity.ok().body(String.valueOf(number).concat(" Products Generated"));
    }
}
