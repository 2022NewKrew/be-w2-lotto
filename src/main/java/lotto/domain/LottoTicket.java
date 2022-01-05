package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> automaticLottoList;
    private final List<Lotto> manualLottoList;

    public LottoTicket(int purchaseAmount, List<String> manualLottoNumberTexts) {
        this.manualLottoList = Collections.unmodifiableList(makeManualLotto(manualLottoNumberTexts));
        this.automaticLottoList = Collections.unmodifiableList(makeAutomaticLotto(calculateAutomaticLottoCount(purchaseAmount, getManualLottoCount())));
    }

    private List<Lotto> makeAutomaticLotto(int automaticLottoCount) {
        List<Lotto> automaticLotto = new ArrayList<>();

        for (int i = 0; i < automaticLottoCount; i++) {
            automaticLotto.add(new Lotto());
        }

        return automaticLotto;
    }

    private List<Lotto> makeManualLotto(List<String> manualLottoNumberTexts) {
        List<Lotto> manualLotto = new ArrayList<>();

        for (String manualLottoNumberText : manualLottoNumberTexts) {
            manualLotto.add(new Lotto(manualLottoNumberText));
        }

        return manualLotto;
    }

    private int calculateAutomaticLottoCount(int purchaseAmount, int manualLottoCount) {
        return (purchaseAmount / LOTTO_PRICE) - manualLottoCount;
    }

    public int getLottoCount() {
        return automaticLottoList.size() + manualLottoList.size();
    }

    public int getManualLottoCount() {
        return manualLottoList.size();
    }

    public int getAutomaticLottoCount() {
        return automaticLottoList.size();
    }

    public List<Lotto> getLottoList() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.addAll(manualLottoList);
        lottoList.addAll(automaticLottoList);

        return lottoList;
    }

    public int getWholeLottoPrice() {
        return LOTTO_PRICE * getLottoCount();
    }

    public LottoWinningResult getLottoWinningResult(List<Integer> winningNumbers, int bonusBallNumber) {
        return new LottoWinningResult(winningNumbers, bonusBallNumber, getLottoList());
    }

}
