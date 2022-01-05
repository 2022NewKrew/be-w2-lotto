package lotto.domain;

import lotto.view.LottoView;

import java.util.*;

import static lotto.domain.LottoConstants.*;

public class LottoManager {
    private int moneyAmount;
    private int numOfLottos;
    private List<LottoNumbers> lottos = new ArrayList<>();

    public LottoManager() {
    }

    public void start() {
        inputMoneyAmount();
        createLottos();
        printLottos();
        makeLottoResult();
    }

    private void inputMoneyAmount() {
        askMoneyAmount();
        moneyAmount = readMoneyAmount();
        numOfLottos = moneyAmount / PRICE_OF_LOTTO;
    }

    private void askMoneyAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    private int readMoneyAmount() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다! 다시 입력해주세요.");
            return readMoneyAmount();
        }
    }

    private void createLottos() {
        for (int i = 0; i < numOfLottos; i++) {
            LottoNumbers ln = new LottoNumbers();
            lottos.add(ln);
        }
    }

    private void printLottos() {
        LottoView lv = new LottoView();
        lv.printLottos(lottos);
    }

    private void makeLottoResult() {
        LottoResult lr = new LottoResult();
        lr.inputWinningLottoNumbers();
        lr.evaluateResult(lottos, moneyAmount);
        lr.printResult();
    }
}
