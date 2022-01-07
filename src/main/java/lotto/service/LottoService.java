package lotto.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.model.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    // TODO 서비스에서 데이터, setter 분리
    private WinningLotto winningLotto;
    private List<Lotto> lottoList;
    private LottoResult lottoResult;

    private long money;
    private long remainingMoney;
    private long manualAmount;

    public LottoService() {
        lottoList = new ArrayList<>();
    }

    public void initializeMoney(long money) {
        this.remainingMoney = this.money = money;
    }

    public void initializeManualAmount(long manualAmount) {
        this.manualAmount = manualAmount;
    }

    public void createWinningLotto(List<Long> winningNumbers, Long bonusNumber) {
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public void checkAllLotto() {
        lottoResult = winningLotto.checkAll(lottoList);
    }

    public Long getManualAmount() {
        return manualAmount;
    }

    public Long getAutomaticAmount() {
        return lottoList.size() - manualAmount;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double getEarningsPercent() {
        return lottoResult.getEarningsPercent(money);
    }

    public boolean enoughMoney() {
        return remainingMoney >= 1000;
    }

    public void purchaseManualLotto(List<Long> numbers) {
        lottoList.add(new Lotto(numbers));
        remainingMoney -= 1000;
    }

    public void purchaseAllAutomaticLotto() {
        while (remainingMoney / 1000 > 0) {
            lottoList.add(new Lotto());
            remainingMoney -= 1000;
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
