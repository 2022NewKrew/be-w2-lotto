package domain.lotto;

import static util.LottoConst.LOTTO_PRICE;

public class LottoGameInfo {

    private final int lottoQuantity;
    private final int autoLottoQuantity;

    public LottoGameInfo(int inputMoney, int manualLottoQuantity) {
        validatePositiveNumber(inputMoney);
        validateInputMoney(inputMoney);
        validateNumOfPurchaseManually(inputMoney, manualLottoQuantity);
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
        this.autoLottoQuantity = this.lottoQuantity - manualLottoQuantity;
    }

    public int getPurchaseQuantity() {
        return lottoQuantity;
    }

    public int getAutomaticallyPurchaseQuantity() {
        return autoLottoQuantity;
    }

    private void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[에러] 음수 값을 입력할 수 없습니다.");
        }
    }

    private void validateInputMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format("[에러] 구입 금액은 반드시 %s원 이상이어야 합니다.", LOTTO_PRICE)
            );
        }
    }

    private void validateNumOfPurchaseManually(int money, int numOfPurchaseManually) {
        if (money < numOfPurchaseManually * LOTTO_PRICE) {
            throw new IllegalArgumentException("[에러] 입력한 금액보다 많은 로또를 구매할 수 없습니다.");
        }
    }
}
