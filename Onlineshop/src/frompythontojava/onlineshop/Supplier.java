package frompythontojava.onlineshop;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Supplier {
    private Integer id;
    private String name;
    private String description;
    public static ArrayList<Supplier> suppliersList = new ArrayList<>();
    private ArrayList<Product> productsList = new ArrayList<>();
    private static ArrayList<Product> productsWithSuppliers = new ArrayList<>();
    private static AtomicInteger number = new AtomicInteger(0);

    public Supplier() {
    }
    public Supplier(String name, String description, ArrayList productsList) {
        this.id = number.getAndIncrement();
        this.name = name;
        this.description = description;
        this.productsList = productsList;
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
    public static Supplier getSupplierById(Integer id) {
        if (suppliersList.size() > 0) {
            for (int i = 0; i < suppliersList.size(); i++)
                if (Objects.equals(suppliersList.get(i).getId(), id)) {
                    return suppliersList.get(i);
                }
        }
        return null;
    }
    public static void createNewSupplier(Supplier supplier) {
        suppliersList.add(supplier);
    }
    public void addProductToSupplier(Product product) {
        this.productsList.add(product);
        Supplier.productsWithSuppliers.add(product);
    }

    public static void listSuppliers(ShopView show) {
        for (int i = 0; i < suppliersList.size(); i++) {
            show.text("Supplier Id: " +suppliersList.get(i).getId() + " Supplier Name: " + suppliersList.get(i).getName());
        }
    }

    public String toString() {
        return String.format("id: %1$d," + "name: %2$s, " + "description: %3$s",
                this.id, this.name, this.description);
    }

    public void listProductsFromSupplier(ShopView show) {
        if (productsList.size() > 0) {
            for (int i = 0; i < productsList.size(); i++) {
                show.text("Product Id: " +productsList.get(i).getId() + " ProductName: " + productsList.get(i).getName() + "\n");
            }
        } else {
            show.text("There are no products from this suppliers.");
        }
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
