package frompythontojava.onlineshop;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        ShopView show = new ShopView();
        show.welcomeText();
        showOptions(show);
        }


//        Product newProduct = new Product(String name, Float price, ProductCategory productCategory, Supplier supplier);

    public static void showOptions(ShopView show){
        show.options();
        chooseOptions(show);


    }
    public static void chooseOptions(ShopView show){
        boolean noInput = true;
        while (noInput) {
            try {
                ShopController take = new ShopController();
                Integer option = take.inputInteger();
                switch (option) {
                    case 1:
                        createNewProduct(show, take);
                        showOptions(show);
                    case 2:
                        addProductsToBasket(show, take);
                        showOptions(show);
                    case 3:
                        seeAllProductsInBasket(show, take);
                        showOptions(show);
                    case 4:
                        removeProductFromBasket(show, take);
                        showOptions(show);
                    case 5:
                        changeSupplierForSpecificProduct(show, take);
                        showOptions(show);
                    case 6:
                        ListOfAvailableProducts(show, take);
                        showOptions(show);
                    case 7:
                        listOfProductsFromSpecificSupplier(show, take);
                        showOptions(show);
                    case 8:
                        listOfProductsFromSpecificProductCategory(show, take);
                        showOptions(show);
                    case 9:
                        createNewSupplier(show, take);
                        showOptions(show);
                    case 10:
                        createNewProductCategoryOrNewFeaturedProductCategory(show, take);
                        showOptions(show);
                    case 11:
                        checkAvailabilityOfSpecificProduct(show, take);
                        showOptions(show);
                    case 12:
                        readProductCategoryDescription(show, take);
                        showOptions(show);
                    case 0:
                        show.text("See you next time!");
                        noInput = false;
                    default:
                        show.text("Wrong input!");
                }
            } catch (InputMismatchException e) {
                show.text("Type only one number!");
            }

        }
    }

    private static void createNewProduct(ShopView show, ShopController take) {
        show.text("Type product name");
        String name = take.inputText();
        show.text("Type product default price");
        Float defaultPrice = take.inputFloat();
        show.text("Type category specification\n");
            show.text("Type category name");
            String categoryName = take.inputText();
            show.text("Type category department");
            String categoryDepartment = take.inputText();
            show.text("Type category description");
            String categoryDescription = take.inputText();
            ProductCategory category = new ProductCategory(categoryName,categoryDepartment,categoryDescription); //TODO tutaj skończyłem, stworzyć obiekt Produkt Category
        show.text("Type supplier for product");
            show.text("Type supplier name");
            String supplierName = take.inputText();
            show.text("Type supplier description");
            String supplierDescription = take.inputText();
            Supplier supplier = new Supplier(supplierName,supplierDescription);
        Product product = new Product(name, defaultPrice, category, supplier);
        Product.addToList(product);
        show.text(product.getName() + " added to list.");
    }

    private static void addProductsToBasket(ShopView show, ShopController take) {
        show.text("Add product to Basket\n");
        if (Product.productList.size() > 0) {
            Product.getProducts();
            show.text("\nChoose number of product you want to add to basket\n");
            Integer id = take.inputInteger();
            Product productToBasket = Product.getProductById(id);
            Basket.addProduct(productToBasket);
            show.text(productToBasket.getName() + " added to basket!");

        } else {
            show.text("\n There are no products in the shop");
        }
    }

    private static void seeAllProductsInBasket(ShopView show, ShopController take) {
    }

    private static void removeProductFromBasket(ShopView show, ShopController take) {
    }

    private static void changeSupplierForSpecificProduct(ShopView show, ShopController take) {
    }

    private static void ListOfAvailableProducts(ShopView show, ShopController take) {
    }

    private static void listOfProductsFromSpecificSupplier(ShopView show, ShopController take) {
    }

    private static void listOfProductsFromSpecificProductCategory(ShopView show, ShopController take) {
    }

    private static void createNewSupplier(ShopView show, ShopController take) {
    }

    private static void createNewProductCategoryOrNewFeaturedProductCategory(ShopView show, ShopController take) {
    }

    private static void checkAvailabilityOfSpecificProduct(ShopView show, ShopController take) {
    }

    private static void readProductCategoryDescription(ShopView show, ShopController take) {
    }
}
