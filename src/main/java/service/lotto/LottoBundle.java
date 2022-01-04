package service.lotto;

import view.util.AutoIncrementIdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class LottoBundle {
    private final List<Lotto> lottoBundle;
    private final Long id = AutoIncrementIdGenerator.get();

    protected LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public Long getId() {
        return id;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    public void confirmTheWin(List<Integer> winningNumbers) {
        lottoBundle.forEach(lotto -> lotto.confirmTheWin(winningNumbers));
    }

    public int getPrizeMoney() {
        return lottoBundle.stream()
                .mapToInt(Lotto::getPrizeMoney)
                .sum();
    }

    public Map<LottoResult, Integer> getLottoResults() {
        Map<LottoResult, Integer> lottoResultsMap = new HashMap<>();
        lottoBundle.forEach(
                lotto -> {
                    lottoResultsMap.putIfAbsent(lotto.getResult(), 0);
                    lottoResultsMap.computeIfPresent(lotto.getResult(), (LottoResult lottoResult, Integer count) -> ++count);
                }
        );
        return lottoResultsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.getId().equals(((LottoBundle) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBundle, id);
    }

    @Override
    public String toString() {
        StringBuilder lottoBundleStringBuilder = new StringBuilder();
        for (Lotto lotto : lottoBundle) {
            lottoBundleStringBuilder.append(lotto.toString()).append("\n");
        }
        return lottoBundleStringBuilder.toString();
    }
}
