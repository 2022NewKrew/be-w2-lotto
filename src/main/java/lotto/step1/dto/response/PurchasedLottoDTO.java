package lotto.step1.dto.response;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottoDTO {
    private final Long id;
    private final List<String> lottoNumbersList;

    private PurchasedLottoDTO(Long id, List<LottoNumbers> lottoNumbersList) {
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

    @Override
    public String toString() {
        return String.join("\n", lottoNumbersList);
    }
}
