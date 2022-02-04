package domain.validator;

import exception.LottoException;
import repository.WinNumbersRepository;

import java.util.List;

public class BonusNumberValidator extends IntegerValidator implements Validator {
    WinNumbersRepository winNumbersRepository = WinNumbersRepository.getWinNumbersRepository();

    @Override
    public void validate(String input) throws LottoException {
        this.isNumeric(input);

        int bonusNumber = Integer.parseInt(input);
        validLottoRange(bonusNumber);

        List<Integer> winNumbers = winNumbersRepository.findWinNumbers();
        if (winNumbers.contains(bonusNumber)) {
            throw new LottoException("보너스 볼은 당첨 번호와 달라야 합니다.");
        }
    }

    private void validLottoRange(Integer num) throws LottoException {
        if (num < 1 || num > 45) {
            throw new LottoException("1~45 범위의 로또 번호를 입력하세요.");
        }
    }
}
