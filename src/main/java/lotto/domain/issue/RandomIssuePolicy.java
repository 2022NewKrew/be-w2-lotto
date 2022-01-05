package lotto.domain.issue;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoConstant.*;

public class RandomIssuePolicy implements IssuePolicy {

    private static final List<Integer> numberList = IntStream.rangeClosed(START, END)
            .boxed().collect(Collectors.toList());

    @Override
    public Lotto issue() {
        Collections.shuffle(numberList);
        List<Integer> tempNumberList = new ArrayList<>(numberList.subList(0, NUMBER_COUNT));
        Collections.sort(tempNumberList);
        return new Lotto(tempNumberList);
    }
}
