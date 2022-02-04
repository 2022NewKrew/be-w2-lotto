package service;

import domain.validator.AmountManualValidator;
import domain.validator.MoneyValidator;
import domain.validator.Validator;
import exception.LottoException;
import repository.LottoInfoRepository;

public class LottoInfoService {
    private static LottoInfoService lottoInfoService = null;
    private final LottoInfoRepository lottoInfoRepository = LottoInfoRepository.getLottoInfoRepository();

    private LottoInfoService() {
    }

    public static LottoInfoService getLottoInfoService() {
        if (lottoInfoService == null) {
            lottoInfoService = new LottoInfoService();
        }
        return lottoInfoService;
    }

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

    public int getAmountManual() {
        return lottoInfoRepository.getAmountManual();
    }

    public int getAmountAuto() {
        return lottoInfoRepository.getAmountAuto();
    }
}
