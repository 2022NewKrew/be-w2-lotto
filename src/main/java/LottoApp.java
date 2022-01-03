import domain.Lotto;
import domain.LottoNumber;
import domain.LottoShop;
import service.LottoGenerator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final LottoShop lottoShop = new LottoShop(new LottoGenerator());

    public static void main(String[] args) {
        int money = inputMoney();
        Lotto lotto = lottoShop.sell(money);
        lotto.print();
        lotto.checkLottoResult(inputWinningNumbers());
        printLottoResult(lotto);

    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private static List<LottoNumber> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Stream.of(sc.nextLine().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void printLottoResult(Lotto lotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        lotto.printResult();
    }
}
