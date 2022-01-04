package lottoStage2.domain.lotto;

import lottoStage2.domain.vo.Discrimination;
import lottoStage2.domain.vo.Number;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    private LottoNumbers() {
        while(numbers.size() < LOTTO_NUMBERS_SIZE) {
            nonDuplicatedAdd();
        }
    }

    private LottoNumbers(String[] numbers) {
        for(String number : numbers) {
            this.numbers.add(Number.of(number));
        }
    }

    public static LottoNumbers create() {
        return new LottoNumbers();
    }

    public static LottoNumbers of(String[] numbers) {
        return new LottoNumbers(numbers);
    }

    private void nonDuplicatedAdd() {
        Number number = Number.create();
        if(!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public Discrimination match(List<Number> targetNumbers, int bonusNumber) {
        List<Number> tempNumbers = new ArrayList<>(numbers);
        boolean matchBonus = tempNumbers.contains(Number.of(bonusNumber));
        tempNumbers.retainAll(targetNumbers);
        int matchCount = tempNumbers.size();

        if(matchCount != 5)
            return new Discrimination(matchCount, false);
        return new Discrimination(matchCount, matchBonus);
    }

    public List<Number> getNumbers() {
        return numbers.stream()
                .sorted(Comparator.comparing(Number::getNumber))
                .collect(Collectors.toList());
    }
}
