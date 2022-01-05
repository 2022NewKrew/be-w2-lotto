package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistic {

    private static final int TREE_WINNING_AMOUNT = 5000;
    private static final int FOUR_WINNING_AMOUNT = 50000;
    private static final int FIVE_WINNING_AMOUNT = 1500000;
    private static final int FIVE_WINNING_AND_BONUS_AMOUNT = 30000000;
    private static final int SIX_WINNING_AMOUNT = 2000000000;

    private int treeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int fiveAndBonusMatch = 0;
    private int sixMatch = 0;
    private int profitRate = 0;

    private int purchaseCount = 0;
    private int normalLottoCount = 0;
    private int autoLottoCount = 0;
    private int winningBonusNumber = 0;

    private List<Lotto> normalLottos;
    private List<Lotto> autoLottos;
    List<Integer> winningNumbers;
    List<Lotto> lottos = new ArrayList<>();

    private LottoStatistic() {
    }

    public LottoStatistic(int purchaseCount, int normalLottoCount, int autoLottoCount) {
        this.purchaseCount = purchaseCount;
        this.normalLottoCount = normalLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public void addLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public void calculateProfitRate() {
        int purchasePrice = purchaseCount * 1000;
        int allWinningAmount = getAllWinningAmount();
        // (평가금액 - 원금) / 원금 * 100
        profitRate = (allWinningAmount - purchasePrice) / purchasePrice * 100;
    }

    private int getAllWinningAmount() {
        int amount = 0;

        amount += treeMatch * TREE_WINNING_AMOUNT;
        amount += fourMatch * FOUR_WINNING_AMOUNT;
        amount += fiveMatch * FIVE_WINNING_AMOUNT;
        amount += fiveAndBonusMatch * FIVE_WINNING_AND_BONUS_AMOUNT;
        amount += sixMatch * SIX_WINNING_AMOUNT;

        return amount;
    }

    public void addLottoInfo(Lotto lotto) {

        switch (lotto.getStatus()) {
            case TREE_WINNING:
                treeMatch++;
                break;
            case FOUR_WINNING:
                fourMatch++;
                break;
            case FIVE_WINNING:
                fiveMatch++;
                break;
            case FIVE_AND_BONUS_WINNING:
                fiveAndBonusMatch++;
            case SIX_WINNING:
                sixMatch++;
                break;
        }
    }

    public String getLottoStatisticString() {

        return "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- " + this.treeMatch + "개\n" +
                "4개 일치 (50000원)- " + this.fourMatch + "개\n" +
                "5개 일치 (1500000원)- " + this.fiveMatch + "개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원)- " + this.fiveMatch + "개\n" +
                "6개 일치 (2000000000원)- " + this.sixMatch + "개\n" +
                "총 수익률은 " + this.profitRate + "%입니다.\n";
    }

    public String getLottoListToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("수동으로 ").append(normalLottoCount).append("장, 자동으로 ").append(autoLottoCount).append("개를 구매했습니다.\n");

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto).append("\n");
        }

        return stringBuilder.toString();
    }

    public void updateStatus(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;

        validationWinningNumberAndWinningBonusNumber();

        updateLottosStatus();

        updateLottoInfo();

        calculateProfitRate();

    }

    private void updateLottoInfo() {
        for (Lotto lotto : lottos) {
            this.addLottoInfo(lotto);
        }
    }

    private void updateLottosStatus() {
        for (Lotto lotto : lottos) {
            lotto.updateStatus(winningNumbers, winningBonusNumber);
        }
    }

    private void validationWinningNumberAndWinningBonusNumber() {
        if(winningNumbers.contains(winningBonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스번호가 같습니다.");
        }
    }

}
