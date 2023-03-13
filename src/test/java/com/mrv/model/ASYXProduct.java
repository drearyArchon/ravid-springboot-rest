package com.mrv.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("asyxproduct_db")
public class ASYXProduct {

    @Id
    private String barcode;

    private String item;

    private String category;

    private int price;

    private int discount;

    private int available;

    public String getBarcode(){
        return this.barcode;
    }

    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public String getItem(){
        return this.item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getDiscount(){
        return this.discount;
    }

    public void setDiscount(int discount){
        this.discount = discount;
    }

    public int getAvailable(){
        return this.available;
    }

    public void setAvailable(int available){
        this.available = available;
    }

    public ASYXProduct(String barcode, String item, String category, int price, int discount, int available) {
        super();
        this.barcode = barcode;
        this.item = item;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.available = available;
    }
}
