package domain;

import java.util.List;

public class LottoValidation {

    private final List<Integer> lotto;

    public LottoValidation(List<Integer> lotto) {
        this.lotto = lotto;
        checkLottoLength();
        checkLottoRange();
        checkDuplication();
    }

    private void checkLottoLength(){
        if(lotto.size() != 6){
            throw new IllegalArgumentException("숫자 6개를 입력해주세요");
        }
    }

    private void checkLottoRange(){
        if(lotto.stream().anyMatch(num -> num <= 0 || num >= 46)){
            throw new IllegalArgumentException("로또 숫자의 범위는 1부터 45까지입니다");
        }
    }

    private void checkDuplication(){
        if(lotto.stream().distinct().count() != lotto.size()){
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다");
        }
    }
}
