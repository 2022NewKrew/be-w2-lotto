package domain.validator;

import exception.LottoException;
import repository.LottoInfoRepository;

public class AmountManualValidator extends IntegerValidator implements Validator {
    LottoInfoRepository lottoInfoRepository = new LottoInfoRepository();

    @Override
    public void validate(String input) throws LottoException {
        this.isNumeric(input);

        int amountManual = Integer.parseInt(input);
        int money = lottoInfoRepository.getMoney();
        int maxBuy = money / 1000;
        if (0 > amountManual || amountManual > maxBuy) {
            throw new LottoException(String.format("최대 %d장까지 구매할 수 있습니다.", maxBuy));
        }
    }
}
