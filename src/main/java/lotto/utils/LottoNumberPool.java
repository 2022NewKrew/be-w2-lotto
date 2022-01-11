package lotto.utils;

import lotto.collections.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumberPool {
    public static final List<LottoNumber> NumberPool = IntStream.range(1, 46).mapToObj(LottoNumber::new).collect(Collectors.toList());

}
