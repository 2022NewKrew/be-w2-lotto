package service;

import domain.validator.AmountManualValidator;
import domain.validator.MoneyValidator;
import domain.validator.Validator;
import exception.LottoException;
import repository.LottoInfoRepository;

public class LottoInfoService {
    LottoInfoRepository lottoInfoRepository = new LottoInfoRepository();

    public void setMoney(String input) throws LottoException {
        Validator validator = new MoneyValidator();
        validator.validate(input);

        int money = Integer.parseInt(input);
        lottoInfoRepository.insertMoney(money);
    }

    public void setAmountManual(String input) throws LottoException {
        Validator validator = new AmountManualValidator();
        validator.validate(input);

        int amountManual = Integer.parseInt(input);
        lottoInfoRepository.insertAmountManual(amountManual);
    }
}
