package com.kakao.lottogame.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.LottoNumber;
import com.kakao.lottogame.domain.Rank;
import com.kakao.lottogame.domain.Result;
import com.kakao.lottogame.domain.WinningLotto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();
    private final List<List<Integer>> LOTTO_NUMBERS = List.of(
        List.of(1, 2, 3, 4, 5, 6),              // SECOND
        List.of(2, 3, 4, 5, 6, 7),              // FIRST
        List.of(5, 6, 7, 8, 9, 10));            // FIFTH
    private final List<Integer> WINNING_LOTTO_NUMBERS = List.of(2, 3, 4, 5, 6, 7);
    private final LottoNumber BONUS_NUMBER = LottoNumber.of(1);

    @DisplayName("로또 수동구매")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void generateManual_Numbers_Lotto(int index) {
        // given
        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.get(index).stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        Lotto expected = Lotto.of(lottoNumbers);

        // when
        Lotto lotto = lottoService.generateManual(LOTTO_NUMBERS.get(index));

        // then
        assertThat(lotto).isEqualTo(expected);
    }

    @DisplayName("로또 자동구매")
    @Test
    void generateAuto_None_Lotto() {
        // given

        // when
        Lotto lotto = lottoService.generateAuto();
        long count = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .filter(value -> lotto.contains(LottoNumber.of(value)))
            .count();

        // then
        assertThat(count).isEqualTo(Lotto.SIZE);
    }

    @DisplayName("당첨 번호와 대조하여 결과를 얻는다.")
    @Test
    void collate_ThreeLottos_FirstSecondFifth() {
        // given
        List<Lotto> lottos = LOTTO_NUMBERS.stream()
            .map(nums -> Lotto.of(nums.stream().map(LottoNumber::of).collect(Collectors.toList())))
            .collect(Collectors.toList());
        List<LottoNumber> lottoNumbers = WINNING_LOTTO_NUMBERS.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(lottoNumbers), BONUS_NUMBER);

        // when
        Result result = lottoService.collate(lottos, winningLotto);

        // then
        assertThat(result.getCountOf(Rank.FIRST)).isOne();
        assertThat(result.getCountOf(Rank.SECOND)).isOne();
        assertThat(result.getCountOf(Rank.THIRD)).isZero();
        assertThat(result.getCountOf(Rank.FOURTH)).isZero();
        assertThat(result.getCountOf(Rank.FIFTH)).isOne();
        assertThat(result.getCountOf(Rank.NONE)).isZero();
    }
}