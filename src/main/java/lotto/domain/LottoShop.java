package lotto.domain;

import lotto.view.InputView;

import java.util.*;

public class LottoShop {
    public static final int PRICE = 1000;
    public static final List<Long> PRIZES = Arrays.asList(0L, 0L, 0L, 5000L, 50_000L, 1_500_000L, 2_000_000_000L);

    private Set<Integer> winnerNumber = new HashSet<>();

    /**
     * {@link Gambler}의 모든 돈으로 로또 구매
     */
    public void sellLottoTicket(Gambler gambler) {
        int toSell = gambler.getMoney() / PRICE;
        System.out.printf("%d개를 구매했습니다.%n", toSell);

        for (int i=0; i<toSell; ++i) {
            Set<Integer> numbers = RandomLottoNumberGenerator.generateRandomLottoNumbers();
            LottoTicket lottoTicket = new LottoTicket(numbers);
            gambler.buyLottoTicket(lottoTicket, PRICE);
            System.out.println(lottoTicket);
        }
    }

    /**
     * {@link Scanner}에서 당첨번호 받아와 등록
     */
    public void setWinnerFromScanner() {
        winnerNumber = InputView.getWinnerNumbersFromScanner("지난 주 당첨 번호를 입력해주세요: ");
    }

    public Set<Integer> getWinnerNumber() {
        return Collections.unmodifiableSet(winnerNumber);
    }
}
