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
    public static void showProductsInBasket(ShopView show) {
        if (productList.size() > 0) {
            Iterator productIterator = new ProductIterator();
            Iterator iterator = productIterator.getIterator();
            while(iterator.hasNext(productList)) {
                Product product = (Product) iterator.next(productList);
                show.text(product.getId() + ". Name: " + product.getName() + " Price: "
                        + product.getDefaultPrice() +"\n");
            }
        } else {
           show.text("There are no products in the shop \n");
        }
    }
    public boolean removeProduct(Product product){
        return true;
    }
}
