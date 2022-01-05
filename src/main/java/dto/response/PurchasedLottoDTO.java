package dto.response;

import model.Lotto;

public class PurchasedLottoDTO {
    private Long id;
    private String lotto;

    private PurchasedLottoDTO(Long id, String lotto) {
        this.id = id;
        this.lotto = lotto;
    }

    public static PurchasedLottoDTO of(Lotto lotto) {
        return new PurchasedLottoDTO(lotto.getId(), lotto.convertLottoToString());
    }

    public Long getId() {
        return id;
    }

    public String getLotto() {
        return lotto;
    }
}
