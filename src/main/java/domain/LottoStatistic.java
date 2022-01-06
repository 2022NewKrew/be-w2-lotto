package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또통계를 보여주는 객체입니다.
 *
 * @author jm.hong
 */
public class LottoStatistic {
    protected static final int LOTTO_END_NUMBER = 45;
    protected static final int LOTTO_START_NUMBER = 1;
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

    List<Integer> winningNumbers;
    List<Lotto> lottos = new ArrayList<>();

    /**
     *
     * @param purchaseCount 총 로또 구매수를 입력합니다.
     * @param normalLottoCount 수동 로또 구매수를 입력합니다.
     * @param autoLottoCount 자동 로또 구매수를 입력합니다.
     * @param lottos 수동, 자동 로또로 구매한 모든 로또 리스트를 입력합니다.
     */
    public LottoStatistic(int purchaseCount, int normalLottoCount, int autoLottoCount, List<Lotto> lottos) {
        this.purchaseCount = purchaseCount;
        this.normalLottoCount = normalLottoCount;
        this.autoLottoCount = autoLottoCount;
        this.lottos = lottos;
    }

    /**
     * @deprecated
     * @param lottos 로또 리스트를 추가합니다.
     */
    public void addLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    /**
     *
     * @return 로또 통계 결과를 String으로 반환합니다.
     */
    public String getLottoStatisticString() {

        return "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- " + this.treeMatch + "개\n" +
                "4개 일치 (50000원)- " + this.fourMatch + "개\n" +
                "5개 일치 (1500000원)- " + this.fiveMatch + "개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원)- " + this.fiveAndBonusMatch + "개\n" +
                "6개 일치 (2000000000원)- " + this.sixMatch + "개\n" +
                "총 수익률은 " + this.profitRate + "%입니다.\n";
    }

    /**
     *
     * @return 로또 구매현황을 String으로 반환합니다.
     */
    public String getLottoListToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("수동으로 ").append(normalLottoCount).append("장, 자동으로 ").append(autoLottoCount).append("개를 구매했습니다.\n");

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto).append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * 현재 LottoStatistic 에 있는 로또들의 당첨상태, 등수별 당첨횟수를 업데이트합니다.
     *
     * @param winningNumbers 로또 당첨번호를 입력합니다.
     * @param winningBonusNumber 로또 보너스번호를 입력합니다.
     */
    public void updateStatus(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;

        validationWinningNumberAndWinningBonusNumber();
        updateLottosStatus();
        updateLottoMatchInfo();
        calculateProfitRate();
    }

    private void updateLottoMatchInfo() {
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
        validateWinningBonusNumbersRange();
        validateWinningNumbersRange();
        validateWinningNumberSixSize();
        validateSameWinningNumberAndWinningBonusNumber();
    }

    private void validateSameWinningNumberAndWinningBonusNumber() {
        if (winningNumbers.contains(winningBonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스번호가 같습니다.");
        }
    }

    private void validateWinningNumberSixSize() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호가 6자리가 아닙니다.");
        }
    }

    private void validateWinningNumbersRange() {
        for (int number : winningNumbers) {
            if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("당첨 번호가 유효한 값이 아닙니다.");
            }
        }
    }

    private void validateWinningBonusNumbersRange() {
        if (winningBonusNumber < LOTTO_START_NUMBER || winningBonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("보너스 번호가 유효한 값이 아닙니다.");
        }
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

    private void calculateProfitRate() {
        int purchasePrice = purchaseCount * 1000;
        int allWinningAmount = getAllWinningAmount();
        // (평가금액 - 원금) / 원금 * 100
        profitRate = (allWinningAmount - purchasePrice) / purchasePrice * 100;
    }

    private void addLottoInfo(Lotto lotto) {

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
                break;
            case SIX_WINNING:
                sixMatch++;
                break;
        }
    }

    public int getTreeMatch() {
        return treeMatch;
    }

    public int getFourMatch() {
        return fourMatch;
    }

    public int getFiveMatch() {
        return fiveMatch;
    }

    public int getFiveAndBonusMatch() {
        return fiveAndBonusMatch;
    }

    public int getSixMatch() {
        return sixMatch;
    }

    public int getProfitRate() {
        return profitRate;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public int getNormalLottoCount() {
        return normalLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
