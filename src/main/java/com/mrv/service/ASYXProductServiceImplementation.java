package com.mrv.service;

import com.mrv.exception.ASYXProductNotFoundException;
import com.mrv.model.ASYXProduct;
import com.mrv.repository.ASYXProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class ASYXProductServiceImplementation implements ASYXProductService {

    @Autowired
    private ASYXProductRepository ASYXProductRepository;

    @Override
    public ASYXProduct createProduct(ASYXProduct product){
        return ASYXProductRepository.save(product);
    }

    @Override
    public ASYXProduct createProductWithBarcode(String barcode){
        Random randNumGen = new Random();
        List<String> categories = Arrays.asList("Accessories", "Full Body Outfits", "Shirts", "Pants", "Shoes");
        String category = categories.get(randNumGen.nextInt(categories.size()));
        int price = randNumGen.nextInt(100) * 1000;
        int discount = randNumGen.nextInt(50);
        int available = randNumGen.nextInt(100, 500);
        ASYXProduct product = new ASYXProduct(barcode, "Item ".concat(barcode), category, price, discount, available);
        return ASYXProductRepository.save(product);
    }

    @Override
    public ASYXProduct updateProduct(ASYXProduct product){
        Optional< ASYXProduct > productDb = this.ASYXProductRepository.findById(product.getBarcode());

        if (productDb.isPresent()) {
            ASYXProduct productUpdate = productDb.get();
            productUpdate.setItemName(product.getItemName());
            productUpdate.setCategory(product.getCategory());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDiscount(product.getDiscount());
            productUpdate.setAvailable(product.getAvailable());
            ASYXProductRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ASYXProductNotFoundException("Record not found with id : " + product.getBarcode());
        }
    }

    @Override
    public List<ASYXProduct> getAllProduct(){
        return this.ASYXProductRepository.findAll();
    }

    @Override
    public List<ASYXProduct> getProductByPriceRange(int min_price, int max_price){
        return this.ASYXProductRepository.findAllInRange(min_price, max_price);
    }

    @Override
    public List<ASYXProduct> getAllProductSortByPrice(){
        return this.ASYXProductRepository.findAll(Sort.by("price"));
    }

    @Override
    public ASYXProduct getProductByBarcode(String barcode){
        Optional <ASYXProduct> product = this.ASYXProductRepository.findById(barcode);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ASYXProductNotFoundException("Product not found with barcode : " + barcode);
        }
    }

    @Override
    public void deleteProduct(String barcode){
        Optional<ASYXProduct> product = this.ASYXProductRepository.findById(barcode);

        if (product.isPresent()) {
            this.ASYXProductRepository.delete(product.get());
        } else {
            throw new ASYXProductNotFoundException("Product not found with barcode : " + barcode);
        }
    }
}
