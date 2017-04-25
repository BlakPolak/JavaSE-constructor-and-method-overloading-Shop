package frompythontojava.onlineshop;

import java.util.ArrayList;

public class Product {
    private Integer id;
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Supplier supplier;
    private ArrayList productList;

    public Product() {
        id = 1;
        name = "TV";
        defaultPrice = 2000f;
        productCategory = new ProductCategory();
        supplier = new Supplier();
//        productList = new Basket().getIterator();

    }
    public Product(String name, Float defaultPrice, ProductCategory productList) {

    }

    public String toString(){
    }

    public ArrayList getProducts(){
        return productList;
    }

    public ArrayList getAllProductsBy(ProductCategory productCategory){

    }

    public ArrayList getAllProductsBy(Supplier productSupplier){

    }
}
