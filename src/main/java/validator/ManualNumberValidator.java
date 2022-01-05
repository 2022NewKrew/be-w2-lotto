package validator;


import exception.LottoException;

public class ManualNumberValidator extends IntegerValidator implements ValidatorInterface {
    private static final int MIN_MANUAL_LOTTO_NUMBER = 0;
    private final int amountOfLotto;

    public ManualNumberValidator(int amountOfLotto) {
        this.amountOfLotto = amountOfLotto;
    }

    @Override
    public void validateData(String input) throws LottoException {
        isNumeric(input);
        validateBoundary(input);
    }

    private void validateBoundary(String input) throws LottoException {
        int manualNumber = Integer.parseInt(input);
        if (manualNumber < MIN_MANUAL_LOTTO_NUMBER || manualNumber > amountOfLotto) {
            throw new LottoException(MIN_MANUAL_LOTTO_NUMBER + "에서" + amountOfLotto + "사이로 입력해주세요.");
        }
    }
}
