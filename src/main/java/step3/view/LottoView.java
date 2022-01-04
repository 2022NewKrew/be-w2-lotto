package step3.view;

import step3.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static step3.utils.CommonConstants.LOTTO_PRICE;

public class LottoView {
    private static final Scanner SCAN = new Scanner(System.in);

    private final Lottos lottos;
    private final Matches matches;

    public LottoView(Lottos lottos) {
        this.lottos = lottos;
        this.matches = new Matches();
    }

    public static int askMoneyForBuyLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyForBuy = SCAN.nextInt();
        int lottosQuantity = moneyForBuy / LOTTO_PRICE;

        if (moneyForBuy < LOTTO_PRICE || lottosQuantity * LOTTO_PRICE != moneyForBuy) {
            throw new NumberFormatException("잘못된 금액이 입력되었습니다.");
        }

        return lottosQuantity;
    }

    public static int askManualLottosQuantity(int lottosQuantity) {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottosQuantity = SCAN.nextInt();

        if (manualLottosQuantity < 0 || manualLottosQuantity > lottosQuantity) {
            throw new NumberFormatException("잘못된 수량이 입력되었습니다.");
        }

        flushScanner();
        return manualLottosQuantity;
    }

    public static List<Lotto> askManualLottos(int manualLottosQuantity) {
        List<Lotto> manualLottos = new ArrayList<>();

        if (manualLottosQuantity > 0) {
            insertManualLottos(manualLottos, manualLottosQuantity);
        }

        return manualLottos;
    }

    private static void insertManualLottos(List<Lotto> manualLottos, int manualLottosQuantity) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < manualLottosQuantity; i++) {
            manualLottos.add(new Lotto(SCAN.nextLine()));
        }
    }

    public Result askResult() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new Result(SCAN.nextLine());
    }

    public BonusNumber askBonusNumber(Result result) {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return new BonusNumber(SCAN.nextInt(), result);
    }

    private static void flushScanner() {
        SCAN.nextLine();
    }

    public void printLottos(int manualLottosQuantity) {
        int lottosQuantity = this.lottos.size();

        System.out.println(manualLottosQuantity != 0 ? "\n수동으로 " + manualLottosQuantity + "개, 자동으로 " +
                (lottosQuantity - manualLottosQuantity) + "개를 구매했습니다." : "\n" + lottosQuantity + "개를 구매했습니다.");

        System.out.println(lottos);
    }

    public void printMatches(Result result, BonusNumber bonusNumber) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        this.matches.matchLottosWithResult(this.lottos, result, bonusNumber);
        System.out.println(this.matches);
    }

    public void printEarningRate() {
        System.out.printf("총 수익률은 %d%%입니다.\n", this.matches.calcEarningsRate(this.lottos));
    }
}
