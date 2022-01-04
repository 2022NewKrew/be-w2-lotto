package dto;

import domain.Lotto;

public class LottoStatistic {

    private final int TREE_WINNING_AMOUNT = 5000;
    private final int FOUR_WINNING_AMOUNT = 50000;
    private final int FIVE_WINNING_AMOUNT = 1500000;
    private final int FIVE_WINNING_AND_BONUS_AMOUNT = 30000000;
    private final int SIX_WINNING_AMOUNT = 2000000000;

    private int purchaseCount = 0;
    private int treeMatch = 0;
    private int fourMatch = 0;
    private int fiveMatch = 0;
    private int fiveAndBonusMatch = 0;
    private int sixMatch = 0;
    private int profitRate = 0;

    public LottoStatistic(int purchaseCount) {
        this.purchaseCount = purchaseCount;

    }

    private void increaseTreeMatch() {
        treeMatch++;
    }

    private void increaseFourMatch() {
        fourMatch++;
    }

    private void increaseFiveMatch() {
        fiveMatch++;
    }

    private void increaseFiveAndBonusMatch() {
        fiveAndBonusMatch++;
    }

    private void increaseSixMatch() {
        sixMatch++;
    }

    public void calculateProfitRate() {
        int purchasePrice = purchaseCount * 1000;
        int allWinningAmount = getAllWinningAmount();
        profitRate = (allWinningAmount * 100 / purchasePrice);
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
                increaseTreeMatch();
                break;
            case FOUR_WINNING:
                increaseFourMatch();
                break;
            case FIVE_WINNING:
                increaseFiveMatch();
                break;
            case FIVE_AND_BONUS_WINNING:
                increaseFiveAndBonusMatch();
            case SIX_WINNING:
                increaseSixMatch();
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
}
