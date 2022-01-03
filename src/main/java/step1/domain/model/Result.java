package step1.domain.model;

import org.apache.commons.lang3.StringUtils;
import step1.exceptions.DifferentSizeException;
import step1.exceptions.EmptyInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step1.utils.CommonConstants.*;

public class Result {

    private final List<Integer> resultList;

    public Result(String resultStr) {
        checkBeforeMakeResultList(resultStr);

        this.resultList = Arrays.stream(resultStr.split(","))
                .map(String::trim).map(Integer::parseInt)
                .filter(num -> num >= START_LOTTO_NUM && num <= END_LOTTO_NUM)
                .distinct().sorted()
                .collect(Collectors.toList());

        checkAfterMakeResultList();
    }

    private void checkBeforeMakeResultList(String resultStr) {
        if (StringUtils.isBlank(resultStr)) {
            throw new EmptyInputException("빈 칸만 입력하셨습니다.");
        }
    }

    private void checkAfterMakeResultList() {
        if (this.resultList.isEmpty()) {
            throw new EmptyInputException("입력하신 결과 중 빈 칸만 입력된 결과 값이 존재합니다.");
        }

        if (this.resultList.size() != RESULT_LOTTO_NUM) {
            throw new DifferentSizeException(this.resultList.size(), RESULT_LOTTO_NUM);
        }
    }

    public int matchWithLotto(Lotto lotto) {
        return (int) this.resultList.stream()
                .filter(lotto::isContainedThisNumber)
                .count();
    }
}
