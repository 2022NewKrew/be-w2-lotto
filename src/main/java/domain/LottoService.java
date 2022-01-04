package domain;

import view.LottoServiceInputController;
import view.LottoServiceRenderer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_PRICE;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public final class LottoService {

    private final LottoServiceInputController inputController;
    private final LottoServiceRenderer renderer;

    public LottoService(LottoServiceInputController inputController, LottoServiceRenderer renderer) {
        this.inputController = inputController;
        this.renderer = renderer;
    }

    public void start() {
        final int purchaseAmount = getPurchaseAmount();
        final List<LottoTicket> purchasedLottoes = purchaseLottoes(purchaseAmount / LOTTO_PRICE.getValue());
        final LottoTicket lastWeekWinning = getLastWeekWinningNumber();
        final int bonusBallNumber = getBonusBallNumber();
        printWinningStatistics(purchaseAmount, purchasedLottoes, lastWeekWinning, bonusBallNumber);
    }

    private int getPurchaseAmount() {
        try {
            return inputController.getPurchaseAmount();
        } catch (InputMismatchException e) {
            renderer.displaySentence("잘못 입력하셨습니다.");
            return getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            renderer.displaySentence(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private List<LottoTicket> purchaseLottoes(int numberOfLottoes) {
        renderer.displaySentence(numberOfLottoes + "개를 구매했습니다.");
        List<LottoTicket> purchasedLottoes = IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> new LottoTicket())
                .collect(Collectors.toUnmodifiableList());
        purchasedLottoes.forEach(renderer::displayLotto);

        return purchasedLottoes;
    }

    private LottoTicket getLastWeekWinningNumber() {
        try {
            return new LottoTicket(inputController.getLastWeekWinningNumber());
        } catch (InputMismatchException e) {
            renderer.displaySentence("잘못 입력하셨습니다.");
            return getLastWeekWinningNumber();
        } catch (IllegalArgumentException e) {
            renderer.displaySentence(e.getMessage());
            return getLastWeekWinningNumber();
        }
    }

    private int getBonusBallNumber() {
        try {
            return inputController.getBonusBallNumber();
        } catch (InputMismatchException e) {
            renderer.displaySentence("잘못 입력하셨습니다.");
            return getBonusBallNumber();
        } catch (IllegalArgumentException e) {
            renderer.displaySentence(e.getMessage());
            return getBonusBallNumber();
        }
    }

    private void printWinningStatistics(int purchaseAmount, List<LottoTicket> purchasedLottoes, LottoTicket lastWeekWinning, int bonusBallNumber) {
        Map<LottoPrize, Long> winningTickets = purchasedLottoes.stream()
                .collect(groupingBy(purchasedLotto -> LottoPrize.getLottoRank(numberOfSameNumbers(purchasedLotto ,lastWeekWinning), isMatchBonusBall(purchasedLotto, bonusBallNumber)), counting()));

        long sumOfPrize = winningTickets.entrySet().stream()
                .mapToLong( e -> e.getKey().getPrizeMoney() * e.getValue())
                .sum();

        renderer.displayResults(winningTickets, sumOfPrize == 0L ? 0.0 : (double)(sumOfPrize - purchaseAmount) / purchaseAmount);
    }

    private boolean isMatchBonusBall(LottoTicket lottoTicket, int bonusBallNumber) {
        return lottoTicket.getLottoNumbers().contains(bonusBallNumber);
    }

    private long numberOfSameNumbers(LottoTicket lottoTicket, LottoTicket lastWeekWinning) {
        List<Integer> myNumbers = lottoTicket.getLottoNumbers();
        List<Integer> winningNumbers = lastWeekWinning.getLottoNumbers();

        return myNumbers.stream().filter(winningNumbers::contains).count();
    }
}
