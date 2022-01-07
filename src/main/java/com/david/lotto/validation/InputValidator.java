package com.david.lotto.validation;

import com.david.lotto.LottoMachine;

import java.util.List;

public class InputValidator {

    private static final String AMOUNT_ERROR_MESSAGE = "구입 금액이 로또 가격보다 적습니다.";
    private static final String MANUAL_COUNT_ERROR_MESSAGE = "구매할 수 있는 로또 수를 초과하였습니다.";
    private static final String LOTTO_SIZE_ERROR_MESSAGE = "로또 번호는 6개입니다.";
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또 번호는 1~45 까지 입니다.";
    private static final String LOTTO_DUPLICATION_ERROR_MESSAGE = "로또 번호가 중복되었습니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "당첨 번호와 중복되었습니다.";

    public void validateAmount(int amount) throws LottoInputException {
        if (amount < LottoMachine.lottoPrice) {
            throw new LottoInputException(AMOUNT_ERROR_MESSAGE);
        }
    }

    public void validateManualCount(int manualCount, int amount) throws LottoInputException {
        if (manualCount * LottoMachine.lottoPrice > amount) {
            throw new LottoInputException(MANUAL_COUNT_ERROR_MESSAGE);
        }
    }

    public void validateLottoNumber(List<Integer> lottoNumber) throws LottoInputException {
        if (lottoNumber.size() != 6) {
            throw new LottoInputException(LOTTO_SIZE_ERROR_MESSAGE);
        }

        if (lottoNumber.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new LottoInputException(LOTTO_NUMBER_ERROR_MESSAGE);
        }

        if (lottoNumber.stream().distinct().count() < 6) {
            throw new LottoInputException(LOTTO_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) throws LottoInputException {
        if (winningNumber.contains(bonusNumber)) {
            throw new LottoInputException(BONUS_NUMBER_ERROR_MESSAGE);
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoInputException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

}
