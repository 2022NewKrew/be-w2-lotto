package dto;

import model.lotto.LottoRecipe;

public class LottoRecipeDto {
    private final int numberOfRandomLotto;
    private final int numberOfManualLotto;

    public LottoRecipeDto(LottoRecipe lottoRecipe) {
        this.numberOfManualLotto = lottoRecipe.getNumberOfManualLotto();
        this.numberOfRandomLotto = lottoRecipe.getNumberOfRandomLotto();
    }

    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }

    public int getNumberOfRandomLotto() {
        return numberOfRandomLotto;
    }
}
