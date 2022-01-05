package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoDTO {

    public static List<Integer> getLastWeekLottoNumberList(String lastWeekLottoNumbers) {
        final String SEPARATOR = ",";
        int[] lastWeekLottoNumberArray = Stream.of(lastWeekLottoNumbers.split(SEPARATOR)).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(lastWeekLottoNumberArray).boxed().collect(Collectors.toList());
    }
}
