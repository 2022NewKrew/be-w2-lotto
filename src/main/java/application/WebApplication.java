package application;

import controller.MainController;

import static spark.Spark.*;


public class WebApplication {

    private static final int PORT_NUMBER = 8080;

    public void run() {
        runControl();
    }

    /**
     * PORT_NUMBER 번호로 WebApplication 을 실행합니다.
     * Controller 가 추가되면 new MainController().run(); 을 통해서 실행합니다.
     */
    private void runControl() {
        port(PORT_NUMBER);
        new MainController().run();
    }
}
