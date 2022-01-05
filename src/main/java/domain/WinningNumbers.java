package domain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTO_SIZE = 6;
    private static final String ILLEGAL_LOTTO_NUMBERS = "로또는 6개의 서로 다른 숫자로 만들어져야 합니다";
    private static final String ILLEGAL_BONUS_NUMBER = "보너스 번호는 6개 로또 번호와 다른 숫자여야 합니다.";
    private static final String DELIMITER_COMMA = ",";
    private final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String lottoNumbersInput, String bonusNumber) {
        String[] lottoNumbers = lottoNumbersInput.split(DELIMITER_COMMA);
        this.lottoNumbers = new TreeSet<>(new ArrayList<>(Arrays.stream(lottoNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList())));
        this.bonusNumber = new LottoNumber(bonusNumber);
        validateLottoSize(this.lottoNumbers);
        validateBonusNumber();
    }

    public WinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateLottoSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBERS);
        }
    }

    private void validateBonusNumber() {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ILLEGAL_BONUS_NUMBER);
        }
    }
    public List<LottoNumber> lottoNumbers() {
        return List.copyOf(lottoNumbers);
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
