package frompythontojava.onlineshop;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Supplier {
    private Integer id;
    private String name;
    private String description;
    private ArrayList<Supplier> suppliersList = new ArrayList<>();
    private  ArrayList<Product> productsList = new ArrayList<>();
    private static AtomicInteger number = new AtomicInteger(0);

    public Supplier() {
    }
    public Supplier(String name, String description) {
        this.id = number.getAndIncrement();
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
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
    public Supplier getSupplierById(int id) {
        if (suppliersList.size() > 0) {
            for (int i = 0; i < suppliersList.size(); i++)
                if (suppliersList.get(i).getId() == id) {
                    return suppliersList.get(i);
                }
        }
        return null;
    }
    public void createNewSupplier(Supplier supplier) {
        suppliersList.add(supplier);
    }

    public String toString() {
        return String.format("id: %1$d," + "name: %2$s, " + "description: %3$s",
                this.id, this.name, this.description);
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
