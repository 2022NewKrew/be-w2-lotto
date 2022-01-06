package domain;

import valid.ConditionCheck;
import view.LottoServiceInputController;
import view.LottoServiceRenderer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_PRICE;
import static view.Sentence.*;

public final class LottoService {

    private final LottoServiceInputController inputController;
    private final LottoServiceRenderer renderer;
    private final LottoGenerator autoLottoGenerator;
    private final LottoGenerator manualLottoGenerator;

    public LottoService(LottoServiceInputController inputController, LottoServiceRenderer renderer, LottoGenerator manualLottoGenerator, LottoGenerator autoLottoGenerator) {
        this.inputController = inputController;
        this.renderer = renderer;
        this.manualLottoGenerator = manualLottoGenerator;
        this.autoLottoGenerator = autoLottoGenerator;
    }

    public void start() {
        final int purchaseAmount = getPurchaseAmount();
        final LottoTickets purchasedLottoTickets = purchaseLottoTickets(purchaseAmount / LOTTO_PRICE.getValue());
        final List<Integer> lastWeekWinning = getLastWeekWinningNumbers();
        final int bonusBallNumber = getBonusBallNumber();
        printWinningStatistics(purchaseAmount, purchasedLottoTickets, lastWeekWinning, bonusBallNumber);
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
     * @param numberOfLottoTickets 구매할 로또 티켓 수
     * @return 구매한 LottoTicket 리스트
     */
    private LottoTickets purchaseLottoTickets(int numberOfLottoTickets) {
        final List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        final int numberOfManualPurchase = getNumberOfManualPurchase(numberOfLottoTickets);
        final int numberOfAutoPurchase = numberOfLottoTickets - numberOfManualPurchase;

        purchasedLottoTickets.addAll(purchaseManualLottoTickets(numberOfManualPurchase));
        purchasedLottoTickets.addAll(purchaseAutoLottTickets(numberOfAutoPurchase));

        renderer.displayPurchaseStatus(purchasedLottoTickets, numberOfManualPurchase, numberOfAutoPurchase);
        return new LottoTickets(purchasedLottoTickets);
    }

    private int getNumberOfManualPurchase(int numberOfLottoTickets) {
        final int numberOfManualPurchase = inputController.getNumberOfManualPurchase();
        if(!ConditionCheck.isNegativeInteger(numberOfManualPurchase) && numberOfManualPurchase <= numberOfLottoTickets) {
            return numberOfManualPurchase;
        }

        renderer.displaySentence(PLEASE_INPUT_WITHIN_TOTAL_PURCHASE_TICKET.getString());
        return getNumberOfManualPurchase(numberOfLottoTickets);
    }

    private List<LottoTicket> purchaseManualLottoTickets(int numberOfLottoTickets) {
        renderer.displaySentence(MANUAL_LOTTO_NUMBER_REQUEST.getString());
        return IntStream.range(0, numberOfLottoTickets)
                .mapToObj(e -> manualLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoTicket> purchaseAutoLottTickets(int numberOfLottoTickets) {
        return IntStream.range(0, numberOfLottoTickets)
                .mapToObj(e -> autoLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }

    /**+
     * 지난 주 당첨 번호를 입력받는 메소드입니다.
     * @return 당첨번호를 리스트를 반환합니다.
     */
    private List<Integer> getLastWeekWinningNumbers() {
        List<Integer> numbers = inputController.getLastWeekWinningNumbers();
        if(ConditionCheck.isValidLottoNumber(numbers)) {
            return Collections.unmodifiableList(numbers);
        }

        System.out.println(ERROR_INAPPROPRIATE_LOTTO_NUMBER.getString());
        return getLastWeekWinningNumbers();
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
     * 당첨 통계 출력하는 메소드입니다. 당첨 현황에 대한 일급 컬렉션을 생성하여 수익률과 같이 renderer에 전달합니다.
     * @param purchaseAmount 구매 금액
     * @param purchasedLottoTickets 구매한 로또 티켓들
     * @param lastWeekWinningNumbers 지난주 당첨 번호
     * @param bonusBallNumber 보너스 볼 번호
     */
    private void printWinningStatistics(int purchaseAmount, LottoTickets purchasedLottoTickets, List<Integer> lastWeekWinningNumbers, int bonusBallNumber) {
        WinningStatus winningStatus = new WinningStatus(purchasedLottoTickets.getWinningStatus(lastWeekWinningNumbers, bonusBallNumber));

        renderer.displayResults(winningStatus, winningStatus.getRateOfReturn(purchaseAmount));
    }
}
