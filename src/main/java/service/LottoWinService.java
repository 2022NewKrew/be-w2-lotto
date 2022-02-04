package service;

import domain.utils.LottoUtils;
import domain.validator.BonusNumberValidator;
import domain.validator.LottoNumberValidator;
import domain.validator.Validator;
import exception.LottoException;
import repository.WinNumbersRepository;

import java.util.List;

public class LottoWinService {
    private static LottoWinService lottoWinService = null;
    private final WinNumbersRepository winNumbersRepository = WinNumbersRepository.getWinNumbersRepository();

    private LottoWinService() {
    }

    public static LottoWinService getLottoWinService() {
        if (lottoWinService == null) {
            lottoWinService = new LottoWinService();
        }
        return lottoWinService;
    }

    public void setWinNumbers(String numbers) throws LottoException {
        Validator validator = new LottoNumberValidator();
        validator.validate(numbers);

        List<Integer> winNumbers = LottoUtils.splitSixNum(numbers);

        winNumbersRepository.insert(winNumbers);
    }

    public void setBonusNumber(String number) throws LottoException {
        Validator validator = new BonusNumberValidator();
        validator.validate(number);

        Integer bonusNumber = Integer.parseInt(number);

        winNumbersRepository.insert(bonusNumber);
    }
}
