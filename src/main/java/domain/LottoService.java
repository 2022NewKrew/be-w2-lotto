package domain;

import view.LottoServiceInputController;
import view.LottoServiceRenderer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_PRICE;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public final class LottoService {

    private final LottoServiceInputController inputController;
    private final LottoServiceRenderer renderer;

    private int purchaseAmount;
    private List<LottoTicket> purchasedLottoes;
    private LottoTicket lastWeekWinning;

    public LottoService(LottoServiceInputController inputController, LottoServiceRenderer renderer) {
        this.inputController = inputController;
        this.renderer = renderer;
    }

    public void start() {
        getPurchaseAmount(); //로또 구입 금액 입력
        purchaseLottoes(purchaseAmount / LOTTO_PRICE.getValue()); //로또 구입 금액만큼 로또 생성
        getLastWeekWinningNumber(); //당첨 번호 입력
        printWinningStatistics(); //당첨 통계 출력
    }

    private void getPurchaseAmount() {
        try {
            purchaseAmount = inputController.getPurchaseAmount();
        } catch (InputMismatchException e) {
            renderer.displaySentence("잘못 입력하셨습니다.");
            getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            renderer.displaySentence(e.getMessage());
            getPurchaseAmount();
        }
    }

    private void purchaseLottoes(int numberOfLottoes) {
        renderer.displaySentence(numberOfLottoes + "개를 구매했습니다.");
        purchasedLottoes = IntStream.range(0, numberOfLottoes)
                .mapToObj(e -> new LottoTicket())
                .collect(Collectors.toUnmodifiableList());
        purchasedLottoes.forEach(renderer::displayLotto);
    }

    private void getLastWeekWinningNumber() {
        try {
            lastWeekWinning = new LottoTicket(inputController.getLastWeekWinningNumber());
        } catch (InputMismatchException e) {
            renderer.displaySentence("잘못 입력하셨습니다.");
            getLastWeekWinningNumber();
        } catch (IllegalArgumentException e) {
            renderer.displaySentence(e.getMessage());
            getLastWeekWinningNumber();
        }
    }

    private void printWinningStatistics() {
        Map<Long, Long> winningTickets = purchasedLottoes.stream().collect(groupingBy(this::numberOfSameNumbers, counting()));

        renderer.displayResults(winningTickets, purchaseAmount);
    }

    private long numberOfSameNumbers(LottoTicket lottoTicket) {
        List<Integer> myNumbers = lottoTicket.getLottoNumbers();
        List<Integer> winningNumbers = lastWeekWinning.getLottoNumbers();

        return myNumbers.stream().filter(winningNumbers::contains).count();
    }
}
