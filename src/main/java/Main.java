import controller.HomeController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HomeController homeController = new HomeController(sc);
        homeController.run();
    }
}
