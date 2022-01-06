package lottery;

import lottery.web.IOController;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        get("/", (req, res) -> "Hello World!");
//        run();
    }

    private static void run() {
        IOController ioController = new IOController();
        ioController.runApp();
    }
}
