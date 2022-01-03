package lotto.step1.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto extends BaseEntity {
    private final List<LottoNumbers> purchasedLottoNumbersList;

    protected Lotto(List<LottoNumbers> purchasedLottoNumbersList) {
        this.purchasedLottoNumbersList = purchasedLottoNumbersList;
    }

    public void confirmTheWin(List<Integer> winningNumbers) {
        for (LottoNumbers lottoNumbers : purchasedLottoNumbersList) {
            lottoNumbers.confirmTheWin(winningNumbers);
        }
    }

    public int getPrizeMoney() {
        return purchasedLottoNumbersList.stream()
                .mapToInt(LottoNumbers::getPrizeMoney)
                .sum();
    }

    public List<LottoNumbers> getPurchasedLottoNumbersList() {
        return purchasedLottoNumbersList;
    }

    public Map<LottoResult, Integer> getLottoResults() {
        Map<LottoResult, Integer> lottoResults = new HashMap<>();
        purchasedLottoNumbersList.forEach(lottoNumbers -> {
            lottoResults.putIfAbsent(lottoNumbers.getResult(), 0);
            lottoResults.computeIfPresent(lottoNumbers.getResult(), (LottoResult result, Integer count) -> ++count);
        });
        return lottoResults;
    }
}
