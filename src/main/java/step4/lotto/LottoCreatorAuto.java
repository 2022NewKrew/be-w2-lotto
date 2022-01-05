package step4.lotto;

import step4.lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreatorAuto implements LottoCreater {

    private static Random random = new Random();

    @Override
    public LottoTicket create() {
        return new LottoTicket(getRandomNumbers());
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> randomNums = IntStream.rangeClosed(1, BIGGEST_LOTTONUM).boxed().collect(Collectors.toList());
        Collections.shuffle(randomNums);

        randomNums = randomNums.subList(0, NUM_OF_LOTTERY_NUMBERS);
        Collections.sort(randomNums);

        return randomNums;
    }
}
