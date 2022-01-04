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

    public LottoService(LottoServiceInputController inputController, LottoServiceRenderer renderer) {
        this.inputController = inputController;
        this.renderer = renderer;
        autoLottoGenerator = new AutoLottoGenerator();
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
        renderer.displaySentence(numberOfLottoes + "개를 구매했습니다.");
        List<LottoTicket> purchasedLottoes = IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> autoLottoGenerator.getLottoTicket())
                .collect(Collectors.toUnmodifiableList());
        purchasedLottoes.forEach(renderer::displayLotto);

        return purchasedLottoes;
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
