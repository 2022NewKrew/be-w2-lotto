package lotto;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoCreatorAuto implements LottoCreater{

    private static Random random = new Random();

    @Override
    public LottoTicket create() {
        return new LottoTicket(getRandomNumbers());
    }

    private List<Integer> getRandomNumbers() {
        ArrayList<Integer> randomNums = new ArrayList<>();
        IntStream.range(0, NUM_OF_LOTTERY_NUMBERS)
                .forEach(i -> randomNums.add(getNextNum(randomNums)));
        return randomNums;
    }



    private Integer getNextNum(List<Integer> nums) {
        int nextNum = random.nextInt(BIGGEST_LOTTONUM + 1);
        while (nums.contains(nextNum)) {
            nextNum = random.nextInt(BIGGEST_LOTTONUM + 1);
        }
        return nextNum;
    }

}
