package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.utils.RandomNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerLotto implements Lotto {

    private final List<Integer> numbers;

    public PlayerLotto() {
        this.numbers = RandomNumbers.getRandomLottoNumbers();
    }

    public PlayerLotto(List<Integer> numbers){
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> list) {
        if(list.size() != Lotto.LOTTO_NUMBER_COUNT_MAX){
            throw new IllegalArgumentException("수동 번호 입력 개수가 유효하지 않습니다.");
        }

        Set<Integer> chkDuplicationSet = new HashSet<>(list);
        if(chkDuplicationSet.size() != Lotto.LOTTO_NUMBER_COUNT_MAX){
            throw new IllegalArgumentException("중복 된 입력 번호가 있습니다.");
        }
    }
}
