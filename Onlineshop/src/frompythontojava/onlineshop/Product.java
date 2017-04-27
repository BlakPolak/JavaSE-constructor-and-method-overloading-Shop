package frompythontojava.onlineshop;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Random;
import java.util.ArrayList;

public class Product {
    private Random rand = new Random();
    private Integer id;
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Supplier supplier;
    private ArrayList<Product> productList;

    public Product() {
        this.id = rand.nextInt(200) + 1;
        this.name = "Product";
        this.defaultPrice = 1f;
        this.productCategory = new ProductCategory();
        this.supplier = new Supplier();

    }
    public Product(String name, Float defaultPrice, ProductCategory productCategory, Supplier supplier) {
        this.id = rand.nextInt(200) + 1;
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.supplier = supplier;

    }


    public void addProductToList(Product newProduct){
        productList.add(newProduct);
    }


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

    public ArrayList getProducts(){
        return productList;
    }

    public ArrayList getAllProductsBy(ProductCategory productCategory){
        return null; //TODO:Implementation
    }

    public ArrayList getAllProductsBy(Supplier productSupplier){
        return null; //TODO:Implementation
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.productCategory.getName(),
                this.supplier.getName());
    }
}



//package com.codecool.shop.model;
//
//        import java.util.Currency;
//
//public class Product extends BaseModel {
//
//    private float defaultPrice;
//    private Currency defaultCurrency;
//    private ProductCategory productCategory;
//    private Supplier supplier;
//
//
//    public Product(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
//        super(name, description);
//        this.setPrice(defaultPrice, currencyString);
//        this.setSupplier(supplier);
//        this.setProductCategory(productCategory);
//    }
//
//    public float getDefaultPrice() {
//        return defaultPrice;
//    }
//
//    public void setDefaultPrice(float defaultPrice) {
//        this.defaultPrice = defaultPrice;
//    }
//
//    public Currency getDefaultCurrency() {
//        return defaultCurrency;
//    }
//
//    public void setDefaultCurrency(Currency defaultCurrency) {
//        this.defaultCurrency = defaultCurrency;
//    }
//
//    public String getPrice() {
//        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
//    }
//
//    public void setPrice(float price, String currency) {
//        this.defaultPrice = price;
//        this.defaultCurrency = Currency.getInstance(currency);
//    }
//
//    public ProductCategory getProductCategory() {
//        return productCategory;
//    }
//
//    public void setProductCategory(ProductCategory productCategory) {
//        this.productCategory = productCategory;
//        this.productCategory.addProduct(this);
//    }
//
//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//        this.supplier.addProduct(this);
//    }
//

//}
