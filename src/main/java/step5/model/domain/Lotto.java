package step5.model.domain;

import org.apache.commons.lang3.StringUtils;
import step5.utils.exception.DifferentSizeException;
import step5.utils.exception.EmptyInputException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step5.utils.CommonConstants.*;

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

    public static Lotto chooseAutoOrManual(String lottoStr) {
        if (lottoStr.length() > 0) {
            return new Lotto(lottoStr);
        }

        return new Lotto();
    }

    private void checkBeforeMakeLottoList(String lottoStr) {
        if (StringUtils.isBlank(lottoStr)) {
            throw new EmptyInputException("입력하신 번호 중 빈 칸으로만 구성된 값이 존재합니다.");
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Integer number : this.lottoList) {
            sb.append(number).append(", ");
        }

        sb.setLength(sb.length() - 2);

        return sb.toString();
    }
}
