package lotto.dto;

import lotto.domain.model.LottoNumber;

public class LottoNumberDTO {

    private final int number;

    public static LottoNumberDTO from(LottoNumber lottoNumber) {
        return new LottoNumberDTO(lottoNumber.getNumber());
    }

    private LottoNumberDTO(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
