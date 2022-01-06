import DIFactory.DIFactory;
import controller.FrontController;

public class LottoMain {
    public static void main(String[] args) {
        FrontController frontController = new FrontController(DIFactory.makeDependency());
        frontController.map();
    }
}
