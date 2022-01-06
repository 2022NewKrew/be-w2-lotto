package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> automaticLottoList;
    private final List<Lotto> manualLottoList;

    public LottoTicket(int purchaseAmount, List<List<Integer>> manualLottoNumbers) {
        this.manualLottoList = Collections.unmodifiableList(makeManualLotto(manualLottoNumbers));
        this.automaticLottoList = Collections.unmodifiableList(makeAutomaticLotto(calculateAutomaticLottoCount(purchaseAmount, getManualLottoCount())));
    }

    private List<Lotto> makeAutomaticLotto(int automaticLottoCount) {
        List<Lotto> automaticLotto = new ArrayList<>();

        for (int i = 0; i < automaticLottoCount; i++) {
            automaticLotto.add(new Lotto());
        }

        return automaticLotto;
    }

    private List<Lotto> makeManualLotto(List<List<Integer>> manualLottoNumbers) {
        List<Lotto> manualLotto = new ArrayList<>();

        for (List<Integer> manualLottoNumber : manualLottoNumbers) {
            manualLotto.add(new Lotto(manualLottoNumber));
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

        return Collections.unmodifiableList(lottoList);
    }

    public int getWholeLottoPrice() {
        return LOTTO_PRICE * getLottoCount();
    }

    public LottoWinningResult getLottoWinningResult(List<Integer> winningNumbers, int bonusBallNumber) {
        return new LottoWinningResult(winningNumbers, bonusBallNumber, getLottoList());
    }

}
