package frompythontojava.onlineshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;


public class ShopController {

    public static String inputString() {
        boolean isWord = false;
        String word = null;
        while (!isWord) {
            try {
                Scanner reader = new Scanner(System.in); // Pomyslec czy nie da się wyciągnąć Scannera do atrybutów klasy
                word = reader.next().trim();
                return word;
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
            }
        }
        return word;
    }

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
        boolean isInteger = false;
        Integer number = null;
        while (!isInteger) {
            try {
                Scanner reader = new Scanner(System.in);
                number = reader.nextInt();
                isInteger = true;
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input! Should be number.");
            }
        }
        return number;
    }

    public static Date inputDate() {
        boolean isDate = false;
        Date date = null;
        while (!isDate) {
            try {
                Scanner reader = new Scanner(System.in);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = reader.next();
                Date rightDate = dateFormat.parse(dateString);
                isDate = true;
                return rightDate;
            } catch (ParseException e) {
                System.out.println("Wrong date format! Should be => dd/MM/yyyy");
            }

        }
        return date;
    }
}
