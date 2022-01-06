package be.w2.lotto.domain.lottonumber;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_NUMBER_RANGE_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void from_객체_생성에_성공하고_LottoNumber_객체를_반환한다() {
        // given
        List<Integer> lottoNumberInputs = List.of(1, 45);
        Class<LottoNumber> expected = LottoNumber.class;

        // when
        List<LottoNumber> actuals = lottoNumberInputs.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        // then
        actuals.forEach(
                actual -> assertThat(actual).isInstanceOf(expected)
        );
    }

    @Test
    void from_로또숫자_범위에_벗어나는_경우_객체_생성에_실패하고_에러를_throw한다() {
        // given
        List<Integer> lottoNumberInputs = List.of(0, 46);

        // when - then
        lottoNumberInputs.forEach(lottoNumber ->
            assertThatThrownBy(() -> LottoNumber.from(lottoNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_RANGE_EXCEPTION)
        );
    }

    @Test
    void getNumber_객체의_number에_해당하는_값을_반환한다() {
        // given
        int expected = 1;
        LottoNumber lottoNumber = LottoNumber.from(expected);

        // when
        int actual = lottoNumber.getNumber();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
