package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    protected ArrayList<LottoBall> lottoNumbers;

    public ArrayList<LottoBall> getLottoNumbers() {
        return lottoNumbers;
    }

    public String toString() {
        return lottoNumbers.stream().map(LottoBall::toString).collect(Collectors.joining(","));
    }

}
