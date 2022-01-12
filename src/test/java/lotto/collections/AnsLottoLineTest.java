package lotto.collections;

import lotto.utils.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnsLottoLineTest {
    static LottoNumber bonusNum = new LottoNumber(35);
    static LottoLine anslottoLine = new LottoLine(new HashSet<LottoNumber>(
            Arrays.asList(1,2,4,7,18,22)
            .stream()
            .map(n -> new LottoNumber(n))
            .collect(Collectors.toList())
    ));
    static AnsLottoLine a1 = new AnsLottoLine(anslottoLine, bonusNum);


    @Test
    @DisplayName("보너스 숫자 제대로 가져오는지 확인")
    void getBonusNum() {
        LottoNumber b1 = a1.getBonusNum();
        assertThat(b1).isEqualTo(bonusNum);
    }

    @Test
    @DisplayName("로또 당첨번호와 비교하여 정확한 순위 불러오는지 확인- 보너스 번호 제외한 경우")
    void countMatchTest1() {
        LottoLine lottoLine1 = new LottoLine(new HashSet<LottoNumber>(
                Arrays.asList(1,2,4,7,19,23)
                        .stream()
                        .map(n -> new LottoNumber(n))
                        .collect(Collectors.toList())
        ));
        Rank rank = a1.countMatch(lottoLine1);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨번호와 비교하여 정확한 순위 불러오는지 확인- 5등")
    void countMatchTest2() {
        LottoLine lottoLine1 = new LottoLine(new HashSet<LottoNumber>(
                Arrays.asList(1,2,4,7,18,35)
                        .stream()
                        .map(n -> new LottoNumber(n))
                        .collect(Collectors.toList())
        ));
        Rank rank = a1.countMatch(lottoLine1);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("특정 번호가 정답번호에 포함되는지 아닌지(보너스 점수는 포함 안함) 1,0 으로 반환")
    void countMatchNumTest1() {
        LottoNumber n2 = new LottoNumber(2);
        int isMatched = a1.countMatchNum(n2);
        assertThat(isMatched).isEqualTo(1);
    }

    @Test
    @DisplayName("특정 번호가 정답번호에 포함되는지 아닌지(보너스 점수는 포함 안함) 1, 0 으로 반환")
    void countMatchNumTest2() {
        LottoNumber n3 = new LottoNumber(3);
        int isMatched = a1.countMatchNum(n3);
        assertThat(isMatched).isEqualTo(0);
    }
}
