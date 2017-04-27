package frompythontojava.onlineshop;

import java.util.Random;

public class Supplier {
    private Random rand = new Random();
    private Integer id;
    private String name;
    private String description;

    public Supplier() {
    }
    public Supplier(String name, String description) {
        this.id = rand.nextInt(200) + 1;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



//package com.codecool.shop.model;
//
//        import java.util.ArrayList;
//
//
//public class Supplier extends BaseModel {
//    private ArrayList<Product> products;
//
//    public Supplier(String name, String description) {
//        super(name);
//        this.products = new ArrayList<>();
//    }
//
//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }
//
//    public ArrayList getProducts() {
//        return this.products;
//    }
//
//    public void addProduct(Product product) {
//        this.products.add(product);
//    }
//
//    public String toString() {
//        return String.format("id: %1$d, " +
//                        "name: %2$s, " +
//                        "description: %3$s",
//                this.id,
//                this.name,
//                this.description
//        );
//    }
//}
