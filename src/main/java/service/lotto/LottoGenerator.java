package service.lotto;

import service.LottoValueObject;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator{
    private static final List<Integer> lottoNumber = IntStream.rangeClosed(LottoValueObject.LOTTO_MIN_VALUE, LottoValueObject.LOTTO_MAX_VALUE).boxed().toList();

    public static Lotto generateLotto(){
        Collections.shuffle(lottoNumber);
        Lotto lotto = new Lotto(lottoNumber.subList(0, LottoValueObject.NUMBER_OF_LOTTERY_NUMBER));
        Collections.sort(lotto.getLotto());
        return lotto;
    }
}