package frompythontojava.onlineshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        ShopView show = new ShopView();
        show.welcomeText();
        showOptions(show);
    }
    
    public static void showOptions(ShopView show) {
        show.options();
        chooseOptions(show);
    }

    public static void chooseOptions(ShopView show) {
        boolean noInput = true;
        while (noInput) {
            ShopController take = new ShopController();
            Integer option = take.inputInteger();
            if (option == 1) {
                createNewProduct(show, take);
                showOptions(show);
            } else if (option == 2 ){
                addProductsToBasket(show, take);
                showOptions(show);
            } else if (option == 3){
                seeAllProductsInBasket(show);
                showOptions(show);
            } else if (option == 4){
                removeProductFromBasket(show, take);
                showOptions(show);
            } else if (option == 5){
                changeSupplierForSpecificProduct(show, take);
                showOptions(show);
            } else if (option == 6){
                ListOfAvailableProducts(show, take);
                showOptions(show);
            } else if (option == 7){
                listOfProductsFromSpecificSupplier(show, take);
                showOptions(show);
            } else if (option == 8){
                listOfProductsFromSpecificProductCategory(show, take);
                showOptions(show);
            } else if (option == 9){
                createNewSupplier(show, take);
                showOptions(show);
            } else if (option == 10){
                createNewProductCategoryOrNewFeaturedProductCategory(show, take);
                showOptions(show);
            } else if (option == 11){
                checkAvailabilityOfSpecificProduct(show, take);
                showOptions(show);
            } else if (option == 12){
                readProductCategoryDescription(show, take);
                showOptions(show);
            } else if (option == 0) {
                show.text("\nSee you next time!\n");
                noInput = false;
                exitProgram();
            } else {
                show.text("\nWrong input!\n");
            }
        }
    }

    private static void exitProgram() {
        System.exit(0);
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
        Supplier supplier = new Supplier(supplierName, supplierDescription,  new ArrayList());
        Product product = new Product(name, defaultPrice, category, supplier);
        Supplier.createNewSupplier(supplier);
        supplier.addProductToSupplier(product);
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
        Supplier supplier = new Supplier(supplierName, supplierDescription, new ArrayList());
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
                        Supplier.createNewSupplier(supplier);
                        supplier.addProductToSupplier(product);
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
        Supplier supplier = new Supplier(supplierName, supplierDescription, new ArrayList());
        FeaturedProductCategory category = new FeaturedProductCategory(featuredCategoryName, featuredCategoryDepartment, featuredCategoryDescription, startDate, endDate);
        Product product = new Product(name, defaultPrice, category, supplier);
        FeaturedProductCategory.addCategoryToList(category);
        category.addProductToCategory(product);
        Product.addToList(product);
        Supplier.createNewSupplier(supplier);
        supplier.addProductToSupplier(product);
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
        Supplier supplier = new Supplier(supplierName, supplierDescription, new ArrayList());
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
                        Supplier.createNewSupplier(supplier);
                        supplier.addProductToSupplier(product);
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
            Boolean isId = false;
            while (!isId){
                Integer id = take.inputInteger();
                if (id <= Product.productList.size()-1 && id >= 0){
                    Product productToBasket = Product.getProductById(id);
                    Basket.addProductToBasket(productToBasket);
                    show.text(productToBasket.getName() + " added to basket!\n");
                    isId = true;
                }else{
                    show.text("Wrong id number!");
                }
            }
        } else {
            show.text("\nThere are no products in the shop\n");
        }
    }

    private static void seeAllProductsInBasket(ShopView show) {
        show.text("\nProducts in basket:\n");
        Basket.showProductsInBasket(show);
    }

    private static void removeProductFromBasket(ShopView show, ShopController take) {
        if (Basket.productList.size() > 0){
            show.text("\nRemove product from basket:\n");
            Basket.showProductsInBasket(show);
            show.text("Choose id of product to remove: ");
            Boolean isId = false;
            while (!isId){
                Integer idToRemove= take.inputInteger();
                if (idToRemove <= Supplier.suppliersList.size()-1 && idToRemove >= 0){
                    Basket.removeProductFromBasket(idToRemove, show);
                    isId = true;
                }else{
                    show.text("Wrong id number!");
                }
            }
        }else {
            show.text("No products in basket");
        }
    }

    private static void changeSupplierForSpecificProduct(ShopView show, ShopController take) {
        if (Product.productList.size()>0){
            show.text("\nAll products in shop\n");
            Product.getProducts();
            show.text("\nChoose id number of product to edit it's supplier\n");
            Boolean isId = false;
            while (!isId){
                Integer idToChangeSupplier = take.inputInteger();
                if (idToChangeSupplier <= Product.productList.size()-1 && idToChangeSupplier >= 0){
                    Product productToChangeSupplier = Product.getProductById(idToChangeSupplier);
                    show.text("\nProduct to change: Name: " +productToChangeSupplier.getName() + " Supplier: " +productToChangeSupplier.getSupplier().getName() + "\n");
                    show.text("Type new supplier name\n");
                    String newName = take.inputText();
                    productToChangeSupplier.getSupplier().setName(newName);
                    show.text("Type new supplier description\n");
                    String newDescription = take.inputText();
                    productToChangeSupplier.getSupplier().setDescription(newDescription);
                    isId = true;
                }else{
                    show.text("Wrong id number!");
                }
            }

        }else{
            show.text("No products in shop!");
        }
    }

    private static void ListOfAvailableProducts(ShopView show, ShopController take) {
        if (Product.productList.size()>0){
            show.text("\nAll available products in shop\n");
            Product.getProducts();
        }else{
            show.text("\nThere are no available products in the shop\n");
        }

    }

    private static void listOfProductsFromSpecificSupplier(ShopView show, ShopController take) {
        if (Supplier.suppliersList.size() > 0) {
            show.text("Choose supplier id: ");
            Supplier.listSuppliers(show);
            Boolean isId = false;
            while (!isId){
                Integer supplierId = take.inputInteger();
                if (supplierId <= Supplier.suppliersList.size()-1 && supplierId >= 0){
                    show.text("\nProducts from supplier: \n");
                    Supplier.getSupplierById(supplierId).listProductsFromSupplier(show);
                    isId = true;
                }else{
                    show.text("Wrong id number!");
                }
            }
        } else {
            show.text("\nThere are no suppliers \n");
        }
    }

    private static void listOfProductsFromSpecificProductCategory(ShopView show, ShopController take) {
        if (ProductCategory.categories.size()> 0) {
            show.text("Categories: \n");
            ProductCategory.getAllCategories(show);
            show.text("Choose id of category to list product from: \n");
            Boolean isId = false;
            while (!isId){
                Integer categoryId = take.inputInteger();
                if (categoryId <= ProductCategory.categories.size()-1 && categoryId >= 0){
                    ProductCategory category = ProductCategory.getProductCategoryById(categoryId);
                    show.text("\nProducts from category " + category.getCategoryName() + ":\n");
                    ProductCategory.getProductsFromCategory(category, show);
                    isId = true;
                } else {
                    show.text("Wrong id number!");
                }
            }
        } else {
            show.text("\nThere are no categories\n");
        }
    }

    private static void createNewSupplier(ShopView show, ShopController take) {
        show.text("Create new supplier\n");
        show.text("Enter supplier name: \n");
        String name = take.inputText();
        show.text("Enter supplier description: ");
        String description = take.inputText();
        Supplier supplier = new Supplier(name, description, new ArrayList());
        Supplier.createNewSupplier(supplier);
        show.text("New supplier " + supplier.getName() + " has been created. \n");
    }

    private static void createNewProductCategoryOrNewFeaturedProductCategory(ShopView show, ShopController take) {
        show.text("Do you want to create featured or normal category?\n" +
                "Featured type => f\n" +
                "Normal type => n\n");
        String featuredOrNormal = take.inputString().toLowerCase();
        if (featuredOrNormal.equals("n")) {
            createNormalCategory(show, take);

        } else if (featuredOrNormal.equals("f")) {
            createFeaturedCategory(show, take);
        }
    }

    private static void createFeaturedCategory(ShopView show, ShopController take) {
        show.text("\nYOU CREATES NORMAL CATEGORY");
        show.text("\nType featured category name");
        String featuredCategoryName = take.inputText();
        show.text("\nType featured category department");
        String featuredCategoryDepartment = take.inputText();
        show.text("\nType featured category description");
        String featuredCategoryDescription = take.inputText();
        show.text("\nType start date (DD/MM/YYYY)");
        Date startDate = take.inputDate();
        show.text("\nType end date (DD/MM/YYYY)");
        Date endDate = take.inputDate();
        FeaturedProductCategory category = new FeaturedProductCategory(featuredCategoryName, featuredCategoryDepartment,
                featuredCategoryDescription, startDate, endDate);
        FeaturedProductCategory.addCategoryToList(category);
        show.text("\n Featured category has been created.");
    }

    private static void createNormalCategory(ShopView show, ShopController take) {
        show.text("\nYOU CREATES NORMAL CATEGORY");
        show.text("\nEnter category name: ");
        String categoryName = take.inputText();
        show.text("\nEnter category department: ");
        String categoryDepartment = take.inputText();
        show.text("\nEnter category description: ");
        String categoryDescription = take.inputText();
        ProductCategory category = new ProductCategory(categoryName, categoryDepartment, categoryDescription);
        ProductCategory.addCategoryToList(category);
        show.text("\n Normal category has been created.");
    }

    private static void checkAvailabilityOfSpecificProduct(ShopView show, ShopController take) {
        if (Product.productList.size() > 0) {
            show.text("Enter product name that you want to find: ");
            String productName = take.inputText();
            Integer iteration = 0;
                for (Product product: Product.productList) {
                    if (productName.equals(product.getName())) {
                        show.text("Product " + productName + " is available.");
                    } else if (!productName.equals(product.getName()) && iteration == Product.productList.size()-1) {
                        show.text("Product " + productName + " is unavailable.");
                    }
                    iteration++;
                }
        } else {
            show.text("There are no products in the shop.");
        }
    }

    private static void readProductCategoryDescription(ShopView show, ShopController take) {
        if (ProductCategory.categories.size() > 0) {
            ProductCategory.getAllCategories(show);

            show.text("Choose id of category to list product from: \n");
            Integer categoryId = take.inputInteger();
            for (int i = 0; i < ProductCategory.categories.size(); i++) {
                if (categoryId == ProductCategory.categories.get(i).getCategoryId()) {
                    show.text("Description: " + ProductCategory.categories.get(i).getCategoryDescription());
                }
            }
        } else {
            show.text("There are no categories.");
        }
    }
}
