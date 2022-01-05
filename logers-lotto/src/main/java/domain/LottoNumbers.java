package domain;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toSet());
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
                .map(lottoNumber -> this.lottoNumbers.contains(lottoNumber))
                .mapToInt(isContained -> isContained ? 1 : 0)
                .reduce(Integer::sum).orElse(0);
    }
}
