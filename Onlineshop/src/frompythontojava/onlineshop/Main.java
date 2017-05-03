package frompythontojava.onlineshop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ShopView show = new ShopView();
        show.welcomeText();
        showOptions(show);
        }


//        Product newProduct = new Product(String name, Float price, ProductCategory category, Supplier supplier);

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
                        seeAllProductsInBasket(show);
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
                        show.text("\nSee you next time!\n");
                        noInput = false;
                    default:
                        show.text("\nWrong input!\n");
                }
            } catch (InputMismatchException e) {
                show.text("\nType only one number!\n");
            }

        }
    }
    private static void createProductAndCategory(ShopView show, ShopController take){
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
        ProductCategory category = new ProductCategory(categoryName, categoryDepartment, categoryDescription); //TODO tutaj skończyłem, stworzyć obiekt Produkt Category
        ProductCategory.addCategoryToList(category);
        show.text("\nType supplier for product\n");
        show.text("Type supplier name");
        String supplierName = take.inputText();
        show.text("Type supplier description");
        String supplierDescription = take.inputText();
        Supplier supplier = new Supplier(supplierName, supplierDescription);
        Product product = new Product(name, defaultPrice, category, supplier);
        category.addProductToCategory(product);
        Product.addToList(product);
        show.text("Product " + product.getName() +". Price " + product.getDefaultPrice()+". Category " + product.getCategoryName() + ". Added to list.\n");
    }

    private static void createProductWithExistingCategory(ShopView show, ShopController take) {
        show.text("Type product name");
        String name = take.inputText();
        show.text("Type product price");
        Float defaultPrice = take.inputFloat();
        show.text("\nType supplier for product\n");
        show.text("Type supplier name");
        String supplierName = take.inputText();
        show.text("Type supplier description");
        String supplierDescription = take.inputText();
        Supplier supplier = new Supplier(supplierName, supplierDescription);
        show.text("\nProduct existing categories: \n");
        ProductCategory.getProductCategories();
        boolean isNoId = true;
        while (isNoId) {
            show.text("\nSelect the category id to which you want to add the product: \n");
            Integer categoryId = take.inputInteger();
            for (int i = 0; i < ProductCategory.categories.size(); i++) {
                if (ProductCategory.categories.get(i).getClass() == new ProductCategory().getClass()) {
                    if (Objects.equals(categoryId, ProductCategory.categories.get(i).getCategoryId())) {
                        Product product = new Product(name, defaultPrice, ProductCategory.categories.get(i), supplier);
                        ProductCategory.categories.get(i).addProductToCategory(product);
                        Product.addToList(product);
                        show.text("Product " + product.getName() + " added to category =>"
                                + ProductCategory.categories.get(i).getCategoryName() + "\n");
                        isNoId = false;
                    }
                } else {
                    show.text("There is no category with such id");
                }
            }
        }
    }

    private static void createFeaturedProductAndCategory(ShopView show, ShopController take){
        show.text("Type product name");
        String name = take.inputText();
        show.text("Type product price");
        Float defaultPrice = take.inputFloat();
        show.text("Type featured category specification\n");
        show.text("Type featured category name");
        String featuredCategoryName = take.inputText();
        show.text("Type featured category department");
        String featuredCategoryDepartment = take.inputText();
        show.text("Type featured category description");
        String featuredCategoryDescription = take.inputText();
        show.text("Type start date (DD/MM/YYYY)\n");
        Date startDate = take.inputDate();
        show.text("Type end date (DD/MM/YYYY)\n");
        Date endDate = take.inputDate();
        show.text("\nType supplier for product\n");
        show.text("Type supplier name");
        String supplierName = take.inputText();
        show.text("Type supplier description");
        String supplierDescription = take.inputText();
        Supplier supplier = new Supplier(supplierName, supplierDescription);
        FeaturedProductCategory category = new FeaturedProductCategory(featuredCategoryName, featuredCategoryDepartment, featuredCategoryDescription, startDate, endDate);
        Product product = new Product(name, defaultPrice, category, supplier);
        FeaturedProductCategory.addCategoryToList(category);
        category.addProductToCategory(product);
        Product.addToList(product);
        show.text("Product " + product.getName() +". Price " + product.getDefaultPrice()+". Featured category " + product.getCategoryName() + ". Added to list.\n");
    }

    private static void createFeaturedProductWithExistingCategory(ShopView show, ShopController take) {
        show.text("Type product name");
        String name = take.inputText();
        show.text("Type product price");
        Float defaultPrice = take.inputFloat();
        show.text("\nType supplier for product\n");
        show.text("Type supplier name");
        String supplierName = take.inputText();
        show.text("Type supplier description");
        String supplierDescription = take.inputText();
        Supplier supplier = new Supplier(supplierName, supplierDescription);
        show.text("\nProduct existing categories: \n");
        FeaturedProductCategory.getFeaturedProductCategories();
        boolean isNoId = true;
        while (isNoId) {
            show.text("\nSelect the category id to which you want to add the product: \n");
            Integer categoryId = take.inputInteger();
            for (int i = 0; i < ProductCategory.categories.size(); i++) {
                if (ProductCategory.categories.get(i).getClass() == new FeaturedProductCategory().getClass()) {
                    if (Objects.equals(categoryId, ProductCategory.categories.get(i).getCategoryId())) {
                        Product product = new Product(name, defaultPrice, ProductCategory.categories.get(i), supplier);
                        ProductCategory.categories.get(i).addProductToCategory(product);
                        Product.addToList(product);
                        show.text("Product " + product.getName() + " added to featured category =>"
                                + ProductCategory.categories.get(i).getCategoryName() + "\n");
                        isNoId = false;
                    }
                } else {
                    show.text("There is no category with such id");
                }
            }
        }
    }

    private static void createNewProduct(ShopView show, ShopController take) {

        show.text("Choose type of product category\n" +
                "1 => normal\n" +
                "2 => featured\n");

        boolean noInput = true;
        while (noInput) {
            try {
                Integer typeNumber = take.inputInteger();
                if (typeNumber == 1) {
                    if (ProductCategory.isThereAnyProductCategory()) {
                        show.text("Product existing categories");
                        ProductCategory.getProductCategories();
                        show.text("Do you want to add product to existing category?\n" +
                                "Type: y => for yes or n => for no");
                        String yesOrNo = take.inputString().toLowerCase();
                        if (Objects.equals(yesOrNo, "n")) {
                            createProductAndCategory(show, take);
                            noInput = false;
                        } else if (Objects.equals(yesOrNo, "y")) {
                            createProductWithExistingCategory(show, take);
                            noInput = false;
                        }
                    } else {
                        show.text("\n There is no existing category. Add new product and new category \n");
                        createProductAndCategory(show, take);
                        noInput = false;
                    }
                }else if (typeNumber == 2) {
                    if (FeaturedProductCategory.isThereFeaturedProductCategory()) {
                        show.text("Product existing categories");
                        FeaturedProductCategory.getFeaturedProductCategories();
                        show.text("Do you want to add product to existing category?\n" +
                                "Type: y => for yes or n => for no");
                        String yesOrNo = take.inputString().toLowerCase();
                        if (Objects.equals(yesOrNo, "n")) {
                            createFeaturedProductAndCategory(show, take);
                            noInput = false;
                        } else if (Objects.equals(yesOrNo, "y")) {
                            createFeaturedProductWithExistingCategory(show, take);
                            noInput = false;
                        }
                    } else {
                        show.text("\n There is no existing category. Add new product and new featured category \n");
                        createFeaturedProductAndCategory(show, take);
                        noInput = false;
                    }
                }else{
                    show.text("Wrong input!");
                }
            }catch(InputMismatchException e) {
                show.text("Type only one number!");
            }
        }
    }

    private static void addProductsToBasket(ShopView show, ShopController take) {
        if (Product.productList.size() > 0) {
            show.text("\nAdd product to Basket\n");
            Product.getProducts();
            show.text("\nChoose number of product you want to add to basket\n");
            Integer id = take.inputInteger();
            Product productToBasket = Product.getProductById(id);
            Basket.addProductToBasket(productToBasket);
            show.text(productToBasket.getName() + " added to basket!\n");

        } else {
            show.text("\nThere are no products in the shop\n");
        }
    }

    private static void seeAllProductsInBasket(ShopView show) {
        show.text("\nProducts in basket:\n");
        Basket.showProductsInBasket(show);
    }

    private static void removeProductFromBasket(ShopView show, ShopController take) {
        show.text("\nRemove product from basket:\n");
        if (Basket.productList.size() > 0){
            Basket.showProductsInBasket(show);
            show.text("Choose id of product to remove: ");
            Integer idToRemove= take.inputInteger();
            Basket.removeProductFromBasket(idToRemove, show);

        }
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
