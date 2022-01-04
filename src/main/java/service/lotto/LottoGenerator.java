package service.lotto;

import service.LottoValueObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> lottoNumber = IntStream.rangeClosed(LottoValueObject.LOTTO_MIN_VALUE, LottoValueObject.LOTTO_MAX_VALUE).boxed().collect(Collectors.toList());

    public static Lotto autoGenerateLotto() {
        Collections.shuffle(lottoNumber);
        Lotto lotto = new Lotto(new ArrayList<>(lottoNumber.subList(0, LottoValueObject.NUMBER_OF_LOTTERY_NUMBER)));
        Collections.sort(lotto.getLotto());
        return lotto;
    }

    public static Lotto manualGenerateLotto(List<Integer> lottoNumber) {
        return new Lotto(new ArrayList<>(lottoNumber));
    }
}