package dto;

import constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultDtoTest {

    @DisplayName("lottoResultDto의 메소드들이 잘 동작하는지")
    @Test
    void testToString() {
        LottoResultDto lottoResultDto = new LottoResultDto();
        lottoResultDto.increase(Rank.FIRST);
        lottoResultDto.increase(Rank.SECOND);
        lottoResultDto.increase(Rank.SECOND);
        lottoResultDto.increase(Rank.THIRD);
        lottoResultDto.increase(Rank.THIRD);
        lottoResultDto.increase(Rank.THIRD);
        lottoResultDto.increase(Rank.FOURTH);
        lottoResultDto.increase(Rank.FOURTH);
        lottoResultDto.increase(Rank.FOURTH);
        lottoResultDto.increase(Rank.FOURTH);
        lottoResultDto.increase(Rank.FIFTH);
        lottoResultDto.increase(Rank.FIFTH);
        lottoResultDto.increase(Rank.FIFTH);
        lottoResultDto.increase(Rank.FIFTH);
        lottoResultDto.increase(Rank.FIFTH);

        lottoResultDto.setWinRate(123456789);
        String predict = "\n당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 5개\n" +
                "4개 일치 (50000원)- 4개\n" +
                "5개 일치 (1500000원)- 3개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- 2개\n" +
                "6개 일치 (2000000000원)- 1개\n" +
                "총 수익률은 123456789%입니다.";

        assertEquals(predict, lottoResultDto.toString());
    }
}
