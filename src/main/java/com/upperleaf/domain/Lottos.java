package com.upperleaf.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    /**
     * 로또 리스트를 생성하는 정적 메서드
     * @param amount 로또 리스트에서 로또의 개수
     * @return 로또 리스트를 표현하는 Lottos 객체
     */
    public static Lottos createLottos(long amount) {
        List<Lotto> lottos = LongStream.range(0, amount)
                .mapToObj(idx -> Lotto.createRandomLotto())
                .collect(Collectors.toUnmodifiableList());
        return new Lottos(lottos);
    }

    /**
     * 로또와 당첨번호를 비교하여, 순서대로 당첨번호와 일치하는 개수를 반환하는 함수.
     * @param winningNumbers 당첨번호
     * @return 로또와 당첨번호간 일치하는 숫자 개수
     */
    public List<Long> matchWinningNumber(List<Integer> winningNumbers) {
        return lottoList.stream()
                .map(lotto -> lotto.match(winningNumbers))
                .collect(Collectors.toList());
    }

    public int getLottosSize() {
        return lottoList.size();
    }

    public String getLottosInfo() {
        StringBuilder sb = new StringBuilder();
        lottoList.forEach(lotto -> sb.append(lotto.getLottoInfo()).append('\n'));
        return sb.toString();
    }
}
