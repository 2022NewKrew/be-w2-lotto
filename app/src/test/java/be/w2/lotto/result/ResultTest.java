package be.w2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @Test
    @DisplayName("당첨 횟수 추가 -> 당첨 숫자 만큼 맞지 않음")
    void add_forNotRewardedCount() {
        //Given
        Result result = getInstance();
        int howManyCorrect = 0;

        //When
        result.add(howManyCorrect);

        //Then
        assertThatNothingChange(result);
    }

    private void assertThatNothingChange(Result result) {
        Map<RewardForCorrect, Integer> stat = result.getStat();
        for (RewardForCorrect rfc : stat.keySet()) {
            assertEquals(0, stat.get(rfc));
        }
    }

    @Test
    @DisplayName("당첨 횟수 추가 -> 당첨 횟수 정상 추가")
    void add_forRewardedCount() {
        //Given
        Result result = getInstance();
        int howManyCorrect = 5;

        //When
        result.add(howManyCorrect);

        //Then
        assertThatCountIncrease(result, howManyCorrect);
    }

    private void assertThatCountIncrease(Result result, int howManyCorrect) {
        Map<RewardForCorrect, Integer> stat = result.getStat();
        for (RewardForCorrect rfc : stat.keySet()) {
            if (howManyCorrect == rfc.getHowManyCorrect())
                assertEquals(1, stat.get(rfc));
        }
    }

    @Test
    @DisplayName("수익 확인하기 -> 당첨된적 없으면 0원")
    void getRevenue_withNothing() {
        //Given
        Result result = getInstance();

        //When
        int revenue = result.getRevenue();

        //Then
        assertEquals(0, revenue);
    }

    @Test
    @DisplayName("수익 확인하기 -> 5개 한번 맞아봄")
    void getRevenue_withOneTimeFiveCorrect() {
        //Given
        Result result = getInstance();
        result.add(5);

        //When
        int revenue = result.getRevenue();

        //Then
        assertEquals(RewardForCorrect.FIVE.getReward(), revenue);
    }

    public static Result getInstance() {
        return new Result();
    }
}