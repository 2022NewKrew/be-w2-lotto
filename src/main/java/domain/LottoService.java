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

    private int getPurchaseAmount() {
        final int amount = inputController.getPurchaseAmount();
        if(ConditionCheck.isPositiveInteger(amount)) {
            return amount;
        }

        renderer.displaySentence(PLEASE_INPUT_POSITIVE_NUMBER.getString());
        return getPurchaseAmount();
    }

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
        if(ConditionCheck.isPositiveInteger(numberOfManualPurchase) && numberOfManualPurchase <= numberOfLottoes) {
            return numberOfManualPurchase;
        }

        renderer.displaySentence(PLEASE_INPUT_WITHIN_TOTAL_PURCHASE_TICKET.getString());
        return getNumberOfManualPurchase(numberOfLottoes);
    }

    private List<LottoTicket> purchaseManualLottoes(int numberOfLottoes) {
        return IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> manualLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoTicket> purchaseAutoLottoes(int numberOfLottoes) {
        return IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> autoLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }

    private LottoTicket getLastWeekWinningNumber() {
        return new WinningLottoGenerator(inputController).getLottoTicket();
    }

    private int getBonusBallNumber() {
        final int bonusNumber = inputController.getBonusBallNumber();
        if(ConditionCheck.isLottoNumber(bonusNumber)) {
            return bonusNumber;
        }

        renderer.displaySentence(INPUT_ERROR.getString() + NEWLINE.getString() + PLEASE_INPUT_WITHIN_LOTTO_NUMBER.getString());
        return getBonusBallNumber();
    }

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
