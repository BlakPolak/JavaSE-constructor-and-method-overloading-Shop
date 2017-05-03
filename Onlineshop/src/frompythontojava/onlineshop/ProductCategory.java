package frompythontojava.onlineshop;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductCategory  {
    protected Integer id;
    protected String name;
    protected String department;
    protected String description;
    public  static ArrayList<ProductCategory> categories = new ArrayList<>();
    private static AtomicInteger number = new AtomicInteger(0);
    private ArrayList<Product> productList = new ArrayList<>();

    public ProductCategory() {
    }
    public ProductCategory(String name,String department, String description) {
        this.id = number.getAndIncrement();
        this.name = name;
        this.department = department;
        this.description = description;
        this.productList = new ArrayList<>();
    }

    public Integer getCategoryId() {
        return id;
    }


    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name){
        this.name = name;
    }

    public String getCategoryDepartment() {
        return department;
    }

    public void setCategoryDepartment(String department) {
        this.department = department;
    }

    public String getCategoryDescription() {
        return description;
    }

    public void setCategoryDescription(String description) {
        this.description = description;
    }



    public void addProductToCategory(Product product) {
        this.productList.add(product);
    }

    public static void getProductCategories() {
        if (categories.size() > 0) {
//            System.out.println("Categories list: ");
            for (int i = 0; i < categories.size(); i++) {
                if (ProductCategory.categories.get(i).getClass() == new ProductCategory().getClass()) {
                    System.out.println(categories.get(i).getCategoryId() + ". " + categories.get(i).getCategoryName() +"\n");
                }
            }
        }
    }
    public static void addCategoryToList(ProductCategory category) {
        categories.add(category);
    }


    public static ProductCategory getProductCategoryById(Integer id) {
        Iterator productIterator = new ProductIterator();
        Iterator iterator = productIterator.getIterator();
        while(iterator.hasNext(categories)) {
            ProductCategory category = (ProductCategory) iterator.next(categories);
            if (Objects.equals(category.getCategoryId(), id)) {
                return category;
            }
        }
        return null;
    }
    public static boolean isThereAnyProductCategory() {
        if (ProductCategory.categories.size() > 0) {
            for (int i = 0; i < categories.size(); i++) {
                if (ProductCategory.categories.get(i).getClass() == new ProductCategory().getClass()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void getAllCategories(ShopView show) {
        if (categories.size() > 0) {
            for (int i = 0; i < categories.size(); i++) {
                show.text("Category id: " + categories.get(i).getCategoryId() + " Category name: "
                        + categories.get(i).getCategoryName() + "\n");
            }
        }
    }

    public static void getProductsFromCategory(ProductCategory productCategory, ShopView show) {
        for (int i = 0; i < productCategory.productList.size(); i++)
            show.text("Product name: " + productCategory.productList.get(i).getName());
    }

    public String toString() {
        return String.format("id: %1$d," + "name: %2$s, " + "department: %3$s, " + "description: %4$s",
                this.id, this.name, this.department, this.description);
    }
}