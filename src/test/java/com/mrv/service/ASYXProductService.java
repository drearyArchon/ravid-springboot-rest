package com.mrv.service;

import com.mrv.model.ASYXProduct;
import java.util.List;

public interface ASYXProductService {

    ASYXProduct createProduct(ASYXProduct product);

    ASYXProduct createProductWithBarcode(String barcode);

    ASYXProduct updateProduct(ASYXProduct product);

    List<ASYXProduct> getAllProduct();

    List<ASYXProduct> getProductByPriceRange(int min_price, int max_price);

    List<ASYXProduct> getAllProductSortByPrice();

    ASYXProduct getProductByBarcode(String barcode);

    void deleteProduct(String barcode);
}
