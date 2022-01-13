package lotto.domain;

import lotto.collections.AnsLottoLine;
import lotto.collections.LottoLine;
import lotto.collections.LottoNumber;
import lotto.collections.RankMap;
import lotto.dto.InputLottoConfig;
import lotto.dto.LottoResults;
import lotto.utils.LottoNumberPool;
import lotto.utils.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPackTest {
    static int n = 3;
    static List<LottoLine> lines = new ArrayList<>(n);
    static InputLottoConfig lottoConfig;
    static LottoPack lottoPack;
    static AnsLottoLine ansLottoLine;


    @BeforeAll
    static void setUp(){
        LottoLine l1 = new LottoLine(new HashSet<LottoNumber>(
                Arrays.asList(1,2,4,7,18,35) //second
                        .stream()
                        .map(n -> new LottoNumber(n))
                        .collect(Collectors.toList())
        ));

        LottoLine l2 = new LottoLine(new HashSet<LottoNumber>(
                Arrays.asList(1,2,4,7,19,36)//fourth
                        .stream()
                        .map(n -> new LottoNumber(n))
                        .collect(Collectors.toList())
        ));

        LottoLine l3 = new LottoLine(new HashSet<LottoNumber>(
                Arrays.asList(1,2,4,10,12,33)//fifth
                        .stream()
                        .map(n -> new LottoNumber(n))
                        .collect(Collectors.toList())
        ));

        lines.add(l1);
        lines.add(l2);
        lines.add(l3);

        lottoConfig = new InputLottoConfig(n, n, lines);
        lottoPack = new LottoPack(lottoConfig);
    }


    @Test
    @DisplayName("로또 번호 잘 저장하는 지 테스트")
    void getLottosTest() {
        List<LottoLine> l2 = lottoPack.getLottos();
        assertThat(l2).isEqualTo(lines);
    }

    @Test
    @DisplayName("로또 당첨 결과 잘 계산하는 지 확인")
    void getResults() {

        LottoLine ansline = new LottoLine(new HashSet<LottoNumber>(
                Arrays.asList(1,2,4,7,18,34)
                        .stream()
                        .map(n -> new LottoNumber(n))
                        .collect(Collectors.toList())
        ));
        LottoNumber bonusNum = new LottoNumber(35);
        ansLottoLine= new AnsLottoLine(ansline, bonusNum);
        LottoResults results = lottoPack.getResults(ansLottoLine);

        RankMap rankMap = new RankMap();
        rankMap.addCnt(Rank.SECOND);
        rankMap.addCnt(Rank.FOURTH);
        rankMap.addCnt(Rank.FIFTH);

        assertThat(results).isEqualTo( new LottoResults(rankMap, 1001833));

    }
}
