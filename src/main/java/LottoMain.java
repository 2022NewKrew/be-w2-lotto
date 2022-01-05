import back.DIFactory.DIFactory;
import front.View;

public class LottoMain {
    public static void main(String[] args) {
        View view = new View(DIFactory.makeDependency());
        view.main();
    }
}
