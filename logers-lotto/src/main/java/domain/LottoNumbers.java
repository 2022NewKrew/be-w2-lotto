package domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(()
                        -> new TreeSet<>(comparing(LottoNumber::getNumber))));
    }

    static void validate(List<Integer> numbers){
        validateSize(numbers.size());
        validateDuplicate(numbers);
        validateValidLottoNumber(numbers);
    }

    private static void validateSize(int numberOfValue){
        if(numberOfValue != Lotto.NUMBER_OF_WRITE_NUMBER){
            throw new IllegalArgumentException(
                    "당첨번호의 갯수는 ".concat(String.valueOf(Lotto.NUMBER_OF_WRITE_NUMBER)).concat("개 입력해주세요."));
        }
    }

    private static void validateDuplicate(List<Integer> numbers){
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private static void validateValidLottoNumber(List<Integer> numbers){
        for(int number : numbers){
            LottoNumber.validate(number);
        }
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }

    public int matchedBy(LottoNumbers otherLottoNumbers){
        return otherLottoNumbers.lottoNumbers.stream()
                .map(this.lottoNumbers::contains)
                .mapToInt(isContained -> isContained ? 1 : 0)
                .reduce(Integer::sum).orElse(0);
    }

    public List<LottoNumber> getLottoNumberList() {
        return List.copyOf(lottoNumbers);
    }
}
