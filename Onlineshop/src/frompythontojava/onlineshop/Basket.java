package frompythontojava.onlineshop;

import java.util.ArrayList;

public class Basket {
    private Iterator iterator;
    private static ArrayList<Product> productList = new ArrayList<>();

    public Iterator getIterator() {
        return iterator;
    }
    public static void addProduct(Product product){
        productList.add(product);

    }
    public boolean removeProduct(Product product){
        return true;
    }
}
