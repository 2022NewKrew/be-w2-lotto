package lotto.domain.component;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private List<LottoNumber> numbers;

    public LottoTicket(String inputLottoNumbers) {
        List<LottoNumber> lottoNumbers = makeLottoTicket(inputLottoNumbers);
        validateLottoNumberCount(lottoNumbers);
        validateDuplicateLottoNumber(lottoNumbers);
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    public LottoTicket(List<LottoNumber> lottoNumberList) {
        validateLottoNumberCount(lottoNumberList);
        validateDuplicateLottoNumber(lottoNumberList);
        this.numbers = new ArrayList<>(lottoNumberList);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    private List<LottoNumber> makeLottoTicket(String inputLottoNumbers) {
        return Arrays.stream(inputLottoNumbers.split(","))
                .map(numStr -> new LottoNumber(Integer.parseInt(numStr)))
                .collect(Collectors.toList());
    }

    private void validateLottoNumberCount(List<LottoNumber> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호의 수는 최소" + LOTTO_NUMBERS_COUNT + "개 입력해야합니다.");
        }
    }

    private void validateDuplicateLottoNumber(List<LottoNumber> numbers) {
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("로또번호는 중복해서 입력할 수 없습니다.");
        }
    }

    private boolean isDuplicateNumber(List<LottoNumber> numbers) {
        return !numbers.stream().allMatch(new HashSet<>()::add);
    }
}
