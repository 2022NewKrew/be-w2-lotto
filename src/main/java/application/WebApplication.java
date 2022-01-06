package application;

import controller.MainController;

import static spark.Spark.*;


public class WebApplication {

    public void run() {
        runControl();
    }

    /**
     *
     */
    private void runControl() {
        port(8080);

        new MainController().run();
    }
}
