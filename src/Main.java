import domain.User;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        OutputView.getInstance().printResult(user);
    }
}
