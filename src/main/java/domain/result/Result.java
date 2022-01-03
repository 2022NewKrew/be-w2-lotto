package domain.result;

import domain.lotto.Lotto;
import domain.lotto.Number;

import java.util.List;
import java.util.stream.Collectors;


public class Result {
    private final Lotto lastLottoResult;

    public Result(List<Number> lottoNumbers) {
        lastLottoResult = new Lotto(lottoNumbers);
    }

    //대상이 되는 로또 번호와 결과 로또 번호중 얼마나 번호가 일치하는지 계산
    public int calculateHittingCnt(Lotto lotto) {
        List<Number> targetNumbers = lotto.getLottoNumbers();

        return targetNumbers.stream()
                .filter(t -> isContain(t))
                .collect(Collectors.toList())
                .size();
    }

    private boolean isContain(final Number targetNumber) {
        return lastLottoResult.getLottoNumbers()
                .stream()
                .filter(l -> l.isSame(targetNumber))
                .findFirst()
                .isPresent();
    }

}
