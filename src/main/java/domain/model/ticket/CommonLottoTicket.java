package domain.model.ticket;

import domain.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class CommonLottoTicket {

    protected final List<LottoNumber> lottoNumbers;

    public CommonLottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = convertToLottNumberList(lottoNumbers);
    }

    protected boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private List<LottoNumber> convertToLottNumberList(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != 6) { throw new IllegalArgumentException("로또 번호는 6자이여야 합니다."); }
        if(isDuplicateNumbers(lottoNumbers)) { throw new IllegalArgumentException("로또 번호는 중복 값을 허용하지 않습니다."); }
    }

    private boolean isDuplicateNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().collect(Collectors.toSet()).size() != lottoNumbers.size();
    }
}
