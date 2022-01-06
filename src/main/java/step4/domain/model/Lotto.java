package step4.domain.model;

import org.apache.commons.lang3.StringUtils;
import step4.exceptions.DifferentSizeException;
import step4.exceptions.EmptyInputException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step4.utils.CommonConstants.*;

public class Lotto {
    private static final List<Integer> AVAIL_LOTTO_NUMS = IntStream
            .range(START_LOTTO_NUM, END_LOTTO_NUM)
            .boxed().collect(Collectors.toList());

    private final List<Integer> lottoList;

    public Lotto() {
        Collections.shuffle(AVAIL_LOTTO_NUMS, new Random(System.nanoTime()));
        List<Integer> chosenNumbers = new ArrayList<>(AVAIL_LOTTO_NUMS.subList(0, RESULT_LOTTO_NUM));
        Collections.sort(chosenNumbers);
        this.lottoList = chosenNumbers;
    }

    public Lotto(String lottoStr) {
        checkBeforeMakeLottoList(lottoStr);

        this.lottoList = Arrays.stream(lottoStr.split(","))
                .map(String::trim).map(Integer::parseInt)
                .filter(num -> num >= START_LOTTO_NUM && num <= END_LOTTO_NUM)
                .distinct().sorted()
                .collect(Collectors.toList());

        checkAfterMakeLottoList();
    }

    private void checkBeforeMakeLottoList(String lottoStr) {
        if (StringUtils.isBlank(lottoStr)) {
            throw new EmptyInputException("빈 칸만 입력하셨습니다.");
        }
    }

    private void checkAfterMakeLottoList() {
        if (this.lottoList.isEmpty()) {
            throw new EmptyInputException("입력하신 번호 중 빈 칸으로만 구성된 값이 존재합니다.");
        }

        if (this.lottoList.size() != RESULT_LOTTO_NUM) {
            throw new DifferentSizeException(this.lottoList.size(), RESULT_LOTTO_NUM);
        }
    }

    public boolean contains(int number) {
        return this.lottoList.contains(number);
    }

    public String getNumbers() {
        return this.lottoList.toString();
    }
}
