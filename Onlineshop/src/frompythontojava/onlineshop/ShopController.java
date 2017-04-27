package frompythontojava.onlineshop;

import java.util.Scanner;
import java.util.InputMismatchException;


public class ShopController {

    public static String inputText() {
        boolean isWord = false;
        String word = null;
        while (!isWord) {
            try {
                Scanner reader = new Scanner(System.in); // Pomyslec czy nie da się wyciągnąć Scannera do atrybutów klasy
                word = reader.nextLine().trim();
                isWord = true;
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
            }
        }
        return word;
    }

    public static Float inputFloat() {
        boolean isFloat = false;
        Float number = null;
        while (!isFloat) {
            try {
                Scanner reader = new Scanner(System.in);
                number = reader.nextFloat();
                isFloat = true;
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input! Should be number.");
            }
        }
        return number;
    }

    public static Integer inputInteger(){
        Scanner reader = new Scanner(System.in);
        Integer number = reader.nextInt();
        return number;
    }
}
