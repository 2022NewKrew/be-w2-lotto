package lotto.step1.dto.response;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottoDTO {
    private final long id;
    private final List<String> lottoNumbersList;

    private PurchasedLottoDTO(long id, List<LottoNumbers> lottoNumbersList) {
        this.id = id;
        this.lottoNumbersList = lottoNumbersList.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.toList());
    }

    public static PurchasedLottoDTO of(Lotto lotto) {
        return new PurchasedLottoDTO(lotto.getId(), lotto.getPurchasedLottoNumbersList());
    }

    public Long getId() {
        return id;
    }

    public List<String> getLottoNumbersList() {
        return lottoNumbersList;
    }

    @Override
    public String toString() {
        return String.join("\n", lottoNumbersList);
    }
}
