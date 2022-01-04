import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoStatics;
import domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @DisplayName("사용자 로또 생성 시 중복 번호 여부 테스트")
    @Test
    void userLottoGeneration_duplicateTest() {
        // Given
        ArrayList<Integer> lottoNumbers = LottoGenerator.generateLotto().getNumbers();

        // When
        Set<Integer> set = new HashSet<>(lottoNumbers);

        // Then
        assertThat(lottoNumbers.size()).isEqualTo(set.size());
    }

    @DisplayName("로또 2등 당첨 작동 여부 테스트")
    @Test
    void lottoEvaluation_secondRankTest() {
        // Given
        Lotto userLotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,7)));
        Lotto answerLotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        int bonusBall = 7;

        // When
        Rank rank = LottoStatics.evaluateLotto(userLotto, answerLotto, bonusBall);

        // Then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 결과 수익률 계산 테스트")
    @Test
    void lottoResults_yieldTest() {
        // Given
        int money = 10000000;
        Map<Rank, Integer> results = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 2,
                Rank.THIRD, 3,
                Rank.FOURTH, 4,
                Rank.FIFTH, 5
        );

        // When
        double yield = LottoStatics.computeYield(results, money);

        // Then
        double actualYield = (double)(2000000000 + 30000000 * 2 + 1500000 * 3 + 50000 * 4 + 5000 * 5)
                / money * 100 - 100;
        assertThat(yield).isEqualTo(actualYield);
    }
}
