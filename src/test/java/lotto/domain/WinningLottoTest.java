package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외를_던진다(){
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusBall = 8;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusBall));
    }

    @Test
    void 당첨_번호가_1보다_작거나_45보다_크면_예외를_던진다(){
        //given
        List<Integer> numbers = List.of(0, 0, 46, 46, 0, 0);
        int bonusBall = 8;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusBall));
    }

    @Test
    void 보너스_볼이_1보다_작거나_45보다_크면_예외를_던진다(){
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusBall = 46;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusBall));
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외를_던진다(){
        //given
        List<Integer> numbers = List.of(1, 2, 2, 4, 5, 6);
        int bonusBall = 42;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusBall));
    }

    @Test
    void 보너스_볼이_당첨_번호와_중복되면_예외를_던진다(){
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusBall = 3;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusBall));
    }
}