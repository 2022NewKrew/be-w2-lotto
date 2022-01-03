package view.util;

public class Validator {

    public static void isPositive(int value){
        if (value <= 0){
            throw new NumberFormatException();
        }
    }
}
