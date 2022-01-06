package com.upperleaf.domain.lotto;

import com.upperleaf.domain.lotto.create.LottoCreateStrategy;

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
     * @param lottoCreateStrategy 로또 생성 전략
     * @return 로또 리스트를 표현하는 Lottos 객체
     */
    public static Lottos createLottos(long amount, LottoCreateStrategy lottoCreateStrategy) {
        List<Lotto> lottos = LongStream.range(0, amount)
                .mapToObj(idx -> lottoCreateStrategy.createLotto())
                .collect(Collectors.toUnmodifiableList());
        return new Lottos(lottos);
    }

    /**
     * 로또와 당첨번호를 비교하여, 당첨등수 반환
     * @param winningNumber 당첨번호
     * @return 로또등수 리스트
     */
    public List<LottoRanking> matchWinningNumber(LottoWinningNumber winningNumber) {
        return lottoList.stream()
                .map(lotto -> lotto.match(winningNumber))
                .collect(Collectors.toList());
    }

    public int getLottosSize() {
        return lottoList.size();
    }

    public List<String> getLottosInfo() {
        return lottoList.stream().map(Lotto::getLottoInfo).collect(Collectors.toList());
    }
}
