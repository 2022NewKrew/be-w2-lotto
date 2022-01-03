package model.scan;

import java.util.Scanner;

public abstract class InputData {
    private static final Scanner scanner = new Scanner(System.in);

    protected static String getInput(){
        return scanner.nextLine()
                .replaceAll(" ", "");
    }
}
