package lotto.validator;

public class InputValidator {

    public static void validateCanPurchaseLotto(int numberOfLotto, int numberOfManualLotto){
        validateNumber(numberOfManualLotto);
        validateCanPurchaseManualLotto(numberOfLotto, numberOfManualLotto);
    }

    public static void validateNumber(int numberOfLotto){
        if(numberOfLotto < 0){
            throw new IllegalArgumentException("입력이 음수입니다.");
        }
    }

    public static void validateCanPurchaseManualLotto(int numberOfLotto, int numberOfManualLotto){
        if(numberOfLotto < numberOfManualLotto){
            throw new IllegalArgumentException("수동으로는 " + numberOfLotto + "장만 구매가 가능합니다.");
        }
    }
}
