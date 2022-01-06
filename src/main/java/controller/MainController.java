package controller;
import static spark.Spark.*;


public class MainController {
    public void run() {
        get("/hellowrld", (req, res) -> {
            return "Hello World";
        });
    }
}
