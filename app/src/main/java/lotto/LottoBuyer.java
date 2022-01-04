package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();

    public final void start() {
        Input.openScanner();
        buyLotto(Input.getMoney());
        OutputView.printLottoList(lottoList);
        Input.closeScanner();
    }

    /**
     * 구매 금액 (price)에 해당하는 로또를 생성해 반환하는 메소드
     *
     * @param price : 구매 금액
     */
    public final void buyLotto(final int price) {
        final int countLotto = price / LOTTO_PRICE;

        OutputView.printCountLotto(countLotto);
        for(int i = 0; i < countLotto; i++) {
            lottoList.add(LottoMachine.generateLotto());
        }
    }
}
