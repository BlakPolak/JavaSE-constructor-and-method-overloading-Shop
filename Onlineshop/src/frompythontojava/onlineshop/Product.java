package frompythontojava.onlineshop;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private Random rand = new Random();
    private Integer id;
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Supplier supplier;
    static ArrayList<Product> productList = new ArrayList<>();
    private static AtomicInteger number = new AtomicInteger(0);

    public Product() {
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory, Supplier supplier) {
        this.id = number.getAndIncrement();
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.supplier = supplier;


    }


    public static void addToList(Product newProduct){
        productList.add(newProduct);
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getDefaultPrice() {
        return defaultPrice;
    }

    public String getCategoryName() {
        return this.productCategory.getCategoryName();
    }

    public static Product getProductById(Integer id) {
        Iterator productIterator = new ProductIterator();
        Iterator iterator = productIterator.getIterator();
        while(iterator.hasNext(productList)) {
            Product product = (Product) iterator.next(productList);
            if (Objects.equals(product.getId(), id)) {
                return product;
            }
        }
        return null;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public static ArrayList getProducts(){
        if (productList.size() > 0) {
            Iterator productIterator = new ProductIterator();
            Iterator iterator = productIterator.getIterator();
            while(iterator.hasNext(productList)) {
                Product product = (Product) iterator.next(productList);
                System.out.println(product.getId() + ". "
                        + product.getName() + " price: "
                        + product.getDefaultPrice());
            }
        } else {
            System.out.println("There are no product in the shop");
        }
        return productList;
    }

//    public static ArrayList getAllProductsBy(ProductCategory productCategory){
//        return null; //TODO:Implementation
//    }
//
//    public static ArrayList getAllProductsBy(Supplier productSupplier){
//        if (productList.size() > 0) {
//            Iterator productIterator = new ProductIterator();
//            Iterator iterator = productIterator.getIterator();
//            while(iterator.hasNext(productList)) {
//                Product product = (Product) iterator.next(productList);
//                System.out.println("Product idL" + product.getId() + ". Supplier name:"
//                        + product.getSupplier().getName() + " price: "
//                        + product.getDefaultPrice());
//            }
//        } else {
//            System.out.println("There are no product in the shop");
//        }
//        return productList;
//    }
//    }

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
                this.productCategory.getCategoryName(),
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
