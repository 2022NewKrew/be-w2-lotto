package dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDTO {
    private static final List<Integer> INIT_LOTTO = IntStream.rangeClosed(1, 46).boxed().collect(Collectors.toList());
    private final List<Integer> number;

    public LottoDTO() {
        List<Integer> numberForShuffle = new ArrayList<>(INIT_LOTTO);
        Collections.shuffle(numberForShuffle);

        number = numberForShuffle.subList(0, 6);
        Collections.sort(number);
    }

    public LottoDTO(String numbers) {
        number = Arrays.stream(numbers.split(",")).map(stringInt -> Integer.valueOf(stringInt.trim())).collect(Collectors.toList());
    }

    public List<Integer> getNumber() {
        return number;
    }

    public int getSameNumber(LottoDTO other) {
        int ret = 0;
        for (Integer n : number) {
            ret += Boolean.compare(other.getNumber().contains(n), false);
        }
        return ret;
    }
}
