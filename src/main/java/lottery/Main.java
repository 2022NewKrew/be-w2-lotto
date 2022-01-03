package lottery;

import lottery.web.IOController;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        IOController ioController = new IOController();
        ioController.runApp();
    }
}
