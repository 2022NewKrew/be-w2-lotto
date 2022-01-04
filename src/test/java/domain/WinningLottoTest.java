package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("로또의 일치 개수가 정확한지 검증")
    @Test
    void compareTo() {
        List<Lotto> userLottoList = List.of(
                new Lotto(List.of(4, 5, 6, 1, 2, 3)),
                new Lotto(List.of(4, 5, 6, 1, 2, 45)),
                new Lotto(List.of(4, 5, 6, 1, 44, 45)),
                new Lotto(List.of(4, 5, 6, 43, 44, 45))
        );

        List<Integer> matchList = userLottoList.stream()
                .map(winningLotto::compareTo)
                .collect(Collectors.toList());

        assertThat(matchList.equals(List.of(6, 5, 4, 3)))
                .isTrue();
    }
}