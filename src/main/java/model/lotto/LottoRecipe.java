package model.lotto;

public class LottoRecipe {
    private final int numberOfRandomLotto;
    private final int numberOfManualLotto;

    public LottoRecipe(int numberOfManualLotto, int numberOfAllLotto) {
        checkNumberOfLottos(numberOfManualLotto, numberOfAllLotto);
        this.numberOfManualLotto = numberOfManualLotto;
        this.numberOfRandomLotto = numberOfAllLotto - numberOfManualLotto;
    }

    private void checkNumberOfLottos(int numberOfManualLotto, int numberOfAllLotto) {
        if (numberOfManualLotto > numberOfAllLotto) {
            throw new IllegalArgumentException("잔액이 부족합니다. (구입할수 있는 로또의 총 개수가 입력받은 수동 로또의 개수보다 작습니다.)");
        }
    }

    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }

    public int getNumberOfRandomLotto() {
        return numberOfRandomLotto;
    }
}
