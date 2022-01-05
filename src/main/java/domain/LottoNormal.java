package domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class LottoNormal extends Lotto {

    public LottoNormal(List<Integer> numbers) {
        super(numbers);
    }

    public static LottoNormal createStringToLottoNumbers(String numbers) {

        List<Integer> list = stream(numbers.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        return new LottoNormal(list);
    }

}
