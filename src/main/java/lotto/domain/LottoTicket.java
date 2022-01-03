package lotto.domain;

public class LottoTicket{
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket issue(LottoNumbersGenerator lottoNumbersGenerator) {
        return new LottoTicket(lottoNumbersGenerator.generateLottoNumbers());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
