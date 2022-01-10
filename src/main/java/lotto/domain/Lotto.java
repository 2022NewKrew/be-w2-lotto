package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.LottoGame;

public class Lotto {

    private final List<Integer> lottoNumber;
//    로또 자동/수동 타입
//    private final Boolean lottoType;

    public Lotto(List<Integer> lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(List<Integer> lottoNumber) {
        final HashSet<Integer> lottoNumberSet = new HashSet<>(lottoNumber);
        if (lottoNumberSet.size() != LottoGame.getLottoNumberSize()) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이뤄져야합니다.");
        }
    }

    public static Lotto valueOf(List<Integer> selectedLottoNumber) {
        final List<Integer> lottoNumber = new ArrayList<>();
        for (Integer number : selectedLottoNumber) {
            if (number.getClass().getSimpleName().equals("Integer")) {
                lottoNumber.add(number);
            }
        }
        return new Lotto(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
