package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator;

    @BeforeEach
    void beforeEach(){
        lottoGenerator = new LottoGenerator();
    }

    @Test
    @DisplayName("로또 자동생성 여부")
    void createLotto(){
        int lottoSize = 6;

        Lotto lotto = lottoGenerator.createLotto();

        assertThat(lotto.getLotto().size()).isEqualTo(lottoSize);
    }

    @Test
    @DisplayName("로또 번호중복 여부")
    void duplicatedLottoNumber(){
        Lotto lotto = lottoGenerator.createLotto();
        int lottoSize = 6;

        List<Integer> distinctLotto = lotto.getLotto().stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(distinctLotto.size()).isEqualTo(lottoSize);
    }
}