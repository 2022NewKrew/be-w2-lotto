package be.w2.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {

    @Test
    @DisplayName("당첨 횟수 추가 -> 당첨 숫자 만큼 맞지 않음, 보너스 없음")
    void add_forNotRewardedCountNoBonus() {
        //Given
        Result result = getInstance();
        int howManyCorrect = 0;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        result.add(correctSpec);

        //Then
        assertThatNothingChange(result);
    }

    @Test
    @DisplayName("당첨 횟수 추가 -> 당첨 숫자 만큼 맞지 않음, 보너스 있음")
    void add_forNotRewardedCountAndBonus() {
        //Given
        Result result = getInstance();
        int howManyCorrect = 0;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, true);

        //When
        result.add(correctSpec);

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
    @DisplayName("당첨 횟수 추가 -> 당첨 횟수 정상 추가 , 보너스와 관련 없는 횟수")
    void add_forRewardedCountWhichIsNoRegardToBonus() {
        //Given
        Result result = getInstance();
        int howManyCorrect = 4;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, false);

        //When
        result.add(correctSpec);

        //Then
        assertEquals(1, result.getStat().get(RewardForCorrect.FOUR));
    }

    @Test
    @DisplayName("당첨 횟수 추가 -> 당첨 횟수 정상 추가 , 보너스와 관련 있는 횟수")
    void add_forRewardedCountWithBonus() {
        //Given
        Result result = getInstance();
        int howManyCorrect = 5;
        CorrectSpec correctSpec = new CorrectSpec(howManyCorrect, true);

        //When
        result.add(correctSpec);

        //Then
        assertEquals(1, result.getStat().get(RewardForCorrect.FIVE_AND_BONUS));
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
    @DisplayName("수익 확인하기 -> 5개 한번 맞아봄(보너스 없음)")
    void getRevenue_withOneTimeFiveCorrectNoBonus() {
        //Given
        Result result = getInstance();
        CorrectSpec correctSpec = new CorrectSpec(5, false);
        result.add(correctSpec);

        //When
        int revenue = result.getRevenue();

        //Then
        assertEquals(RewardForCorrect.FIVE.getReward(), revenue);
    }

    @Test
    @DisplayName("수익 확인하기 -> 5개 한번 맞아봄(보너스 있음)")
    void getRevenue_withOneTimeFiveCorrectAndBonus() {
        //Given
        Result result = getInstance();
        CorrectSpec correctSpec = new CorrectSpec(5, true);
        result.add(correctSpec);

        //When
        int revenue = result.getRevenue();

        //Then
        assertEquals(RewardForCorrect.FIVE_AND_BONUS.getReward(), revenue);
    }

    public static Result getInstance() {
        return new Result();
    }
}