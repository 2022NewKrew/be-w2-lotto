package com.kakao.lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private int LOTTO_NUMBER = 6;
    static private List<Integer> lottoNumbers = new ArrayList<>();

    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        makeRandomLotto();
    }

    static {
        for(int i = 1; i <= 45; i++)
            lottoNumbers.add(i);
    }

    // lottoNumber 만큼의 Lotto를 랜덤하게 만들어 lottos List를 만들어줍니다.
    static public List<Lotto> makeLottos(int lottoNumber) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoNumber; i++)
            lottos.add(new Lotto());
        return lottos;
    }

    // 랜덤하게 하나의 로또를 만들어줍니다
    private void makeRandomLotto() {
        Collections.shuffle(lottoNumbers);
        lotto = new ArrayList<>(lottoNumbers.subList(0, LOTTO_NUMBER));
        Collections.sort(lotto);
    }

    // lotto에 해당 number가 포함되어있는지 확인해줍니다.
    private int isContain(int number) {
        if(lotto.contains(number))
            return 1;
        return 0;
    }

    // lotto의 숫자들 중 당첨 번호와 몇 개가 일치하는지 리턴해줍니다.
    public int getSameNumber(List<Integer> winningNumbers) {
        int sameNumber = 0;
        for(int i = 0; i < LOTTO_NUMBER; i++) {
            sameNumber += isContain(winningNumbers.get(i));
        }
        return sameNumber;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

}
