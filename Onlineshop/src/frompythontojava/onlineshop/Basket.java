package frompythontojava.onlineshop;

import java.util.ArrayList;
import java.util.Objects;

public class Basket {
    private Iterator iterator;
    public static ArrayList<Product> productList = new ArrayList<>();

    public Iterator getIterator() {
        return iterator;
    }
    public static void addProductToBasket(Product product){
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
           show.text("There are no products in the basket \n");
        }
    }
    public static void removeProductFromBasket(Integer idToRemove,ShopView show){
        if (productList.size() > 0) {
            Iterator productIterator = new ProductIterator();
            Iterator iterator = productIterator.getIterator();
            Product removedProduct = Product.getProductById(idToRemove);
            while(iterator.hasNext(productList)) {
                Product product = (Product) iterator.next(productList);
                if (Objects.equals(product.getId(), idToRemove)) {
                    productList.remove(product);
                }
            }
            show.text(removedProduct.getId() + ". Name: " + removedProduct.getName() + "removed from basket\n");
        } else {
            show.text("There are no products in your basket \n");
        }
    }
}
