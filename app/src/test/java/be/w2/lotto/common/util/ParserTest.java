package be.w2.lotto.common.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseInputNumbers_입력이_String이면_파싱해서_Integer_리스트를_반환한다() {
        // given
        String inputString = "1, 2, 3, 4, 5, 6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> actual = Parser.parseInputNumbers(inputString);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void parseInputNumbers_입력이_String_리스트이면_파싱해서_Integer_리스트의_리스트를_반환한다() {// given
        List<String> inputStrings = List.of("1, 2, 3, 4, 5, 6", "6, 5, 4, 3, 2, 1");
        List<List<Integer>> expected = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(6, 5, 4, 3, 2, 1));

        // when
        List<List<Integer>> actual = Parser.parseInputNumbers(inputStrings);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}