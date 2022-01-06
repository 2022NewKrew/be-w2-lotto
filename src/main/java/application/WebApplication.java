package application;

import controller.MainController;

import static spark.Spark.*;


public class WebApplication {

    private static final int PORT_NUMBER = 8080;

    public void run() {
        runControl();
    }

    private void runControl() {
        port(PORT_NUMBER);
        new MainController().run();
    }
}
