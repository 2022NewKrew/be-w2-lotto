package lotto.domain;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoGeneratorTest {
    private LottoPaper lp;
    private LottoGenerator lg;

    @BeforeEach
    void testSetting(){
        lp = new LottoPaper();
        lp.inputPrice = 3000;
        lp.numOfNumbers = 3;
        lg = new LottoGenerator(lp);
        lg.generateLotto(0);
    }

    @DisplayName("자동 로또 생성 갯수 확인")
    @Test
    void generateLottoTest() {

        assertThat(lp.lottoNumbers.size()).isEqualTo(3);
    }

    @DisplayName("객체 일치 여부 확인")
    @Test
    void getLottoPaperTest(){
        assertThat(lg.getLottoPaper()).isEqualTo(lp);
    }
}