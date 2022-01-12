package lotto.utils;

import lotto.collections.LottoLine;
import lotto.collections.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumberPool {
    public static final List<LottoNumber> NumberPool = IntStream.range(1, 46).mapToObj(LottoNumber::new).collect(Collectors.toList());

    public static LottoLine getSixNumbers(){
        shuffleNumbers();
        Set<LottoNumber> listToSet = new HashSet<>(NumberPool.subList(0,6));
        LottoLine oneLottoLine = new LottoLine(listToSet);
        return oneLottoLine;
    }

    private static void shuffleNumbers(){
        Collections.shuffle(NumberPool);
    }

}
