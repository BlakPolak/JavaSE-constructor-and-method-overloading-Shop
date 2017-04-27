package frompythontojava.onlineshop;

import java.util.Random;

public class ProductCategory  {
    private Random rand = new Random();
    private Integer id;
    private String name;
    private String department;
    private String description;

    public ProductCategory() {
    }
    public ProductCategory(String name,String department, String description) {
        this.id = rand.nextInt(200) + 1;
        this.name = name;
        this.department = department;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String toString() {
        return String.format("id: %1$d," + "name: %2$s, " + "department: %3$s, " + "description: %4$s",
                this.id, this.name, this.department, this.description);
    }
}



//package com.codecool.shop.model;
//
//
//        import java.lang.reflect.Field;
//
//public class BaseModel {
//
//    protected int id;
//    protected String name;
//    protected String description;
//
//    public BaseModel(String name) {
//        this.name = name;
//    }
//
//    public BaseModel(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder();
//        for (Field field : this.getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            Object value = null;
//            try {
//                value = field.get(this);
//                if (value != null) {
//                    sb.append(field.getName() + ":" + value + ",");
//                }
//            } catch (IllegalAccessException e) {
//
//            }
//        }
//        return sb.toString();
//    }

