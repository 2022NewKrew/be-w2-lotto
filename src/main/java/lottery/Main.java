package lottery;

import lottery.web.IOController;
import lottery.web.WebIOController;

public class Main {
    public static void main(String[] args) {

        runWebApp();
//        run();
    }

    private static void runWebApp() {
        WebIOController webIOController = new WebIOController();
        webIOController.run();
    }

    private static void run() {
        IOController ioController = new IOController();
        ioController.runApp();
    }
}
