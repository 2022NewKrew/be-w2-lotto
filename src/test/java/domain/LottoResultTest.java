package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    LottoList lottoList;

    @BeforeEach
    void beforeEach(){
        lottoList = new LottoList();
    }

    @Test
    @DisplayName("로또 당첨 결과 체크")
    void lottoResultCheck(){
        Lotto winningLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;

        List<Lotto> manualLottoList = new ArrayList<>();

        manualLottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        manualLottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
        manualLottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 9))));
        manualLottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9))));
        manualLottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 10))));

        lottoList.createManualLottoList(manualLottoList);

        LottoResult lottoResult = new LottoResult(lottoList, winningLotto, bonusNumber);

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .map(rank -> assertThat(lottoResult.getLottoResult().get(rank)).isEqualTo(1))
                .close();
    }
}