package com.kakao.lotto.step3.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public final static int LOTTO_COUNT = 6;
    private static List<Integer> lottoNumbers = Stream.iterate(1, number -> number + 1).limit(45).collect(Collectors.toList());

    private List<Integer> lotto;

    public Lotto() {
        lotto = new ArrayList<>();
        makeRandomLotto();
    }
    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    // lottoNumber 만큼의 Lotto를 랜덤하게 만들어 lottos List를 만들어줍니다.
    public static List<Lotto> makeRandomLottos(int lottoCount) {
        return Stream.generate(Lotto::new).limit(lottoCount).collect(Collectors.toList());
    }

    // 랜덤하게 하나의 로또를 만들어줍니다
    private void makeRandomLotto() {
        Collections.shuffle(lottoNumbers);
        lotto = new ArrayList<>(lottoNumbers.subList(0, LOTTO_COUNT));
        Collections.sort(lotto);
    }

    // lotto의 숫자들 중 당첨 번호와 몇 개가 일치하는지 리턴해줍니다.
    public int getCountOfMatch(List<Integer> winningNumbers) {
        return (int)lotto.stream().filter(number -> winningNumbers.contains(number)).count();
    }

    public boolean getMatchBonus(int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

}
