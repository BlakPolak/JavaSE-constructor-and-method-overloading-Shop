package frompythontojava.onlineshop;

import java.util.Date;

public class FeaturedProductCategory extends ProductCategory {
    private Date startDate;
    private Date endDate;

    public FeaturedProductCategory(){

    }
    public FeaturedProductCategory(String name, String department, String description, Date startDate, Date endDate){
        super(name, department, description);
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public static void getFeaturedProductCategories() {
        if (categories.size() > 0) {
//            System.out.println("Featured categories: ");
            for (int i = 0; i < categories.size(); i++) {
                if (ProductCategory.categories.get(i).getClass() == new FeaturedProductCategory().getClass()) {
                    System.out.println(categories.get(i).getCategoryId() + ". " + categories.get(i).getCategoryName() + "\n");
                }
            }
        }
    }

    public static boolean isThereFeaturedProductCategory () {
        if (ProductCategory.categories.size() > 0) {
            for (int i = 0; i < categories.size(); i++) {
                if (ProductCategory.categories.get(i).getClass() == new FeaturedProductCategory().getClass()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("id: %1$d," + "name: %2$s, " + "department: %3$s, " +
                "description: %4$s" + "startDate: %5s " +"endDate: %6s",
                this.id, this.name, this.department, this.description, this.startDate, this.endDate);
    }

}

