package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoInfo.*;

public class AutoLotto implements LottoGenerator {
    private static final List<Integer> LOTTO_NUMS = IntStream.range(MIN_NUMBER.getValue(), MAX_NUMBER.getValue()).boxed().collect(Collectors.toList());

    private final int countOfAutoLotto;

    public AutoLotto(int countOfAutoLotto) {
        this.countOfAutoLotto = countOfAutoLotto;
    }

    @Override
    public List<Lotto> generateTickets() {
        return IntStream.range(0, countOfAutoLotto)
                .mapToObj(ticket -> generateTicket()).collect(Collectors.toList());
    }

    private Lotto generateTicket(){
        List<Integer> lottoNums = new ArrayList<>(LOTTO_NUMS);
        Collections.shuffle(lottoNums);
        List<Integer> autoLottoTicket = lottoNums.subList(0, COUNT_OF_NUMBER.getValue());
        Collections.sort(autoLottoTicket);
        return new Lotto(autoLottoTicket);
    }
}