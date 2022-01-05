package domain;

import valid.ConditionCheck;
import view.LottoServiceInputController;
import view.LottoServiceRenderer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_PRICE;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static view.Sentence.*;

public final class LottoService {

    private final LottoServiceInputController inputController;
    private final LottoServiceRenderer renderer;
    private final LottoGenerator autoLottoGenerator;
    private final LottoGenerator manualLottoGenerator;

    public LottoService(LottoServiceInputController inputController, LottoServiceRenderer renderer) {
        this.inputController = inputController;
        this.renderer = renderer;
        autoLottoGenerator = new AutoLottoGenerator();
        manualLottoGenerator = new ManualLottoGenerator(inputController);
    }

    public void start() {
        final int purchaseAmount = getPurchaseAmount();
        final List<LottoTicket> purchasedLottoes = purchaseLottoes(purchaseAmount / LOTTO_PRICE.getValue());
        final LottoTicket lastWeekWinning = getLastWeekWinningNumber();
        final int bonusBallNumber = getBonusBallNumber();
        printWinningStatistics(purchaseAmount, purchasedLottoes, lastWeekWinning, bonusBallNumber);
    }

    /**+
     * 구매금액 가져오는 메소드입니다. 구매금액이 0보다 크지 않으면 재귀호출하여 다시 가져옵니다.
     * @return 0보다 큰 금액
     */
    private int getPurchaseAmount() {
        final int amount = inputController.getPurchaseAmount();
        if(ConditionCheck.isPositiveInteger(amount)) {
            return amount;
        }

        renderer.displaySentence(PLEASE_INPUT_POSITIVE_NUMBER.getString());
        return getPurchaseAmount();
    }

    /**+
     * 인자 값으로 주어진 개수만큼 로또를 구매하는 메소드입니다.
     * @param numberOfLottoes
     * @return 구매한 LottoTicket 리스트
     */
    private List<LottoTicket> purchaseLottoes(int numberOfLottoes) {
        final List<LottoTicket> purchasedLottoes = new ArrayList<>();
        final int numberOfManualPurchase = getNumberOfManualPurchase(numberOfLottoes);

        purchasedLottoes.addAll(purchaseManualLottoes(numberOfManualPurchase));
        purchasedLottoes.addAll(purchaseAutoLottoes(numberOfLottoes - numberOfManualPurchase));

        renderer.displayPurchaseStatus(purchasedLottoes);
        return Collections.unmodifiableList(purchasedLottoes);
    }

    private int getNumberOfManualPurchase(int numberOfLottoes) {
        final int numberOfManualPurchase = inputController.getNumberOfManualPurchase();
        if(!ConditionCheck.isNegativeInteger(numberOfManualPurchase) && numberOfManualPurchase <= numberOfLottoes) {
            return numberOfManualPurchase;
        }

        renderer.displaySentence(PLEASE_INPUT_WITHIN_TOTAL_PURCHASE_TICKET.getString());
        return getNumberOfManualPurchase(numberOfLottoes);
    }

    private List<LottoTicket> purchaseManualLottoes(int numberOfLottoes) {
        renderer.displaySentence(MANUAL_LOTTO_NUMBER_REQUEST.getString());
        return IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> manualLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoTicket> purchaseAutoLottoes(int numberOfLottoes) {
        return IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> autoLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }

    /**+
     * 지난 주 당첨 번호를 입력받는 메소드입니다.
     * @return 당첨번호를 가지고 내부 속성값 Winning을 가지는 LottoTicket을 반환합니다.
     */
    private LottoTicket getLastWeekWinningNumber() {
        return new WinningLottoGenerator(inputController).getLottoTicket();
    }

    /**+
     * 보너스 볼 입력받는 메소드입니다. 입력받은 값이 로또 번호 범위를 벗어나면 재귀호출하여 다시 가져옵니다.
     * @return 로또 번호 범위 내의 숫자 값
     */
    private int getBonusBallNumber() {
        final int bonusNumber = inputController.getBonusBallNumber();
        if(ConditionCheck.isLottoNumber(bonusNumber)) {
            return bonusNumber;
        }

        renderer.displaySentence(INPUT_ERROR.getString() + NEWLINE.getString() + PLEASE_INPUT_WITHIN_LOTTO_NUMBER.getString());
        return getBonusBallNumber();
    }

    /**+
     * 당첨 통계 출력하는 메소드입니다. 당첨된 등수와 해당 등수의 개수를 map으로 묶고, 수익률을 (평가금액 - 원금) / 원금 으로 퍼센티지를 계산하여 renderer에 전달합니다.
     * @param purchaseAmount
     * @param purchasedLottoes
     * @param lastWeekWinning
     * @param bonusBallNumber
     */
    private void printWinningStatistics(int purchaseAmount, List<LottoTicket> purchasedLottoes, LottoTicket lastWeekWinning, int bonusBallNumber) {
        Map<LottoPrize, Long> winningTickets = purchasedLottoes.stream()
                .collect(groupingBy(purchasedLotto -> LottoPrize.getLottoRank(numberOfSameNumbers(purchasedLotto ,lastWeekWinning), isMatchBonusBall(purchasedLotto, bonusBallNumber)), counting()));

        long sumOfPrize = winningTickets.entrySet().stream()
                .mapToLong( e -> e.getKey().getPrizeMoney() * e.getValue())
                .sum();

        renderer.displayResults(winningTickets, getRateOfReturn(sumOfPrize, purchaseAmount));
    }

    private boolean isMatchBonusBall(LottoTicket lottoTicket, int bonusBallNumber) {
        return lottoTicket.getLottoNumbers().contains(bonusBallNumber);
    }

    private long numberOfSameNumbers(LottoTicket lottoTicket, LottoTicket lastWeekWinning) {
        List<Integer> myNumbers = lottoTicket.getLottoNumbers();
        List<Integer> winningNumbers = lastWeekWinning.getLottoNumbers();

        return myNumbers.stream().filter(winningNumbers::contains).count();
    }

    private double getRateOfReturn(long sumOfPrize, int purchaseAmount) {
        return sumOfPrize == 0L ? 0.0 : (double)(sumOfPrize - purchaseAmount) / purchaseAmount * 100;
    }
}
