package validator;


public class ManualNumberValidator extends IntegerValidator implements ValidatorInterface{
    private static final int MIN_MANUAL_LOTTO_NUMBER = 0;
    private final int amountOfLotto;

    public ManualNumberValidator(int amountOfLotto) { this.amountOfLotto = amountOfLotto; }

    @Override
    public boolean validateData(String input) {
        return isNumeric(input) && validateBoundary(input);
    }

    private boolean validateBoundary(String input){
        int manualNumber = Integer.parseInt(input);
        if(manualNumber < MIN_MANUAL_LOTTO_NUMBER || manualNumber > amountOfLotto) {
            System.out.println(MIN_MANUAL_LOTTO_NUMBER + "에서" + amountOfLotto + "사이로 입력해주세요.");
            return false;
        }
        return true;
    }
}
