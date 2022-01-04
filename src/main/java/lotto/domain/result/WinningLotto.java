package lotto.domain.result;

import lotto.domain.lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto implements Lotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> list) {
        validateNumbers(list);
        this.numbers = list;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> list){
        if(list.size() != Lotto.LOTTO_NUMBER_COUNT_MAX){
            throw new IllegalArgumentException("당첨 번호 입력 개수가 유효하지 않습니다.");
        }

        Set<Integer> chkDuplicationSet = new HashSet<>(list);
        if(chkDuplicationSet.size() != Lotto.LOTTO_NUMBER_COUNT_MAX){
            throw new IllegalArgumentException("중복 된 당첨 번호가 있습니다.");
        }
    }
}
