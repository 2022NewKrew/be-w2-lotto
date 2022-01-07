package lotto.domain.winningstats.lastweeknumberBundle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LastWeekLottoNumberList {
    List<Integer> lastWeekLottoNumberList;

    public LastWeekLottoNumberList(String lastWeekLottoNumbers) {
        final String SEPARATOR = ",";
        int[] lastWeekLottoNumberArray = Stream.of(lastWeekLottoNumbers.split(SEPARATOR)).mapToInt(Integer::parseInt).toArray();
        lastWeekLottoNumberList = Arrays.stream(lastWeekLottoNumberArray).boxed().collect(Collectors.toUnmodifiableList());
    }

    public boolean contains(int lottoNumber){
        return lastWeekLottoNumberList.contains(lottoNumber);
    }
}
