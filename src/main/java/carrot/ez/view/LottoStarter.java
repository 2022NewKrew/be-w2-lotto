package carrot.ez.view;

import carrot.ez.io.ConsoleIOController;
import carrot.ez.user.User;

import java.util.List;

public class LottoStarter {

    private final static ConsoleIOController io = new ConsoleIOController();

    public static void start() {
        User user = createUser();
        purchaseLotteries(user);
        printLotteries(user);
        checkWiningLotteries(user);
        printWiningResults(user);
    }

    private static User createUser() {
        long amount = io.inputLong("구입 금액을 입력해주세요.");
        User user = new User(amount);
        return user;
    }

    private static void purchaseLotteries(User user) {
        user.purchaseLotteries();
    }

    private static void printLotteries(User user) {
        user.printLotteries();
    }

    private static void checkWiningLotteries(User user) {
        List<Integer> wins = io.inputSplitInt("지난 주 당첨 번호를 입력해 주세요.", "\\s*[,]\\s*");
        int bonus = io.inputInt("보너스 볼을 입력해주세요.");
        user.checkWinningLotteries(wins, bonus);
    }

    private static void printWiningResults(User user) {
        user.printWiningLotteries();
        user.printEarningRate();
    }

    private LottoStarter() {
    }
}
