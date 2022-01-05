package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoStatisticTest {
    LottoStatistic lottoStatistic;
    @BeforeEach
    void setUp() {
        lottoStatistic = new LottoStatistic();
    }

    @Test
    @DisplayName("통계 초기화 후 수익률 계산")
    void initialize() {
        List<Lotto> userLottos = new ArrayList<Lotto>();
        userLottos.add(new DefaultLotto("1, 2, 3, 4, 5, 6"));
        userLottos.add(new DefaultLotto("4, 5, 6, 7, 8, 9"));
        userLottos.add(new DefaultLotto("4, 5, 6, 7, 11, 12"));
        Lotto pastWinningLotto = new DefaultLotto("4, 5, 6, 7, 8, 9");
        lottoStatistic.initialize(userLottos, pastWinningLotto);
        Map winningCountMap = new HashMap<Integer, Long>();
        winningCountMap.put(6, 1L);
        winningCountMap.put(5, 0L);
        winningCountMap.put(4, 1L);
        winningCountMap.put(3, 1L);
        assertThat(lottoStatistic.getWinningCountMap()).isEqualTo(winningCountMap);
        assertThat(lottoStatistic.getProfitPercentage()).isEqualTo(66668400);
    }

}