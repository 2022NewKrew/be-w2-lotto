package step1.view;

import step1.domain.model.Lottos;
import step1.domain.model.Matches;
import step1.domain.model.Result;

import java.util.Scanner;

import static step1.utils.CommonConstants.LOTTO_PRICE;

public class LottoView {
    private static final Scanner SCAN = new Scanner(System.in);

    private final Lottos lottos;
    private final Matches matches;

    public LottoView(Lottos lottos) {
        this.lottos = lottos;
        this.matches = new Matches();
    }

    public static int askMoneyForBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyForBuy = SCAN.nextInt();
        int lottosQuantity = moneyForBuy / LOTTO_PRICE;

        checkMoneyForBuyLotto(moneyForBuy, lottosQuantity);

        System.out.println(lottosQuantity + "개를 구매했습니다.");
        return lottosQuantity;
    }

    private static void checkMoneyForBuyLotto(int moneyForBuy, int quantity) {
        if (moneyForBuy < LOTTO_PRICE || quantity * LOTTO_PRICE != moneyForBuy) {
            throw new NumberFormatException("잘못된 금액이 입력되었습니다.");
        }
    }

    public void printLottos() {
        System.out.println(lottos);
    }

    public Result askResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        SCAN.nextLine();
        return new Result(SCAN.nextLine());
    }

    public void printMatches(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        this.matches.matchLottosWithResult(this.lottos, result);
        System.out.println(this.matches);
    }

    public void printEarningRate() {
        System.out.printf("총 수익률은 %d%%입니다.\n", this.matches.calcEarningsRate(this.lottos));
    }
}
