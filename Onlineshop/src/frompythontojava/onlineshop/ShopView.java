package frompythontojava.onlineshop;


public class ShopView {
    private String ANSI_RED;
    private String ANSI_RESET;
    private String ANSI_GREEN;
    private String ANSI_PURPLE;
    private String ANSI_CYAN;

    public ShopView(){
    }

    public void welcomeText(){
        System.out.println(ANSI_RED+ "Welcome in Java Shop" +ANSI_RESET );
        System.out.println(ANSI_GREEN  + "     Choose the option    " + ANSI_RESET );
    }

    public void options(){
        System.out.println(ANSI_PURPLE + "1 => Create new product" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "2 => Add some products to the basket" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "3 => See all products in your basket"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "4 => Remove product from basket"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "5 => Change supplier for specific product"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "6 => Get list of all available products"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "7 => Get list of products from specific supplier"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "8 => Get list of products from specific product category"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "9 => Create new supplier"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "10 => Create new product category or new featured product category"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "11 => Check availability of specific product"+ ANSI_RESET);
        System.out.println(ANSI_PURPLE + "12 => Read product category description"+ ANSI_RESET);
    }
    public void text(String text){
        System.out.println(text);
    }
}
