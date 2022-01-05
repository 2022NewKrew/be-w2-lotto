package dto.request;

import java.util.List;

public class LottoCheckDTO {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private Long lottoId;

    public LottoCheckDTO(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void setLottoId(Long lottoId) {
        this.lottoId = lottoId;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Long getLottoId() {
        return lottoId;
    }
}
