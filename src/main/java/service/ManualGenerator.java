package service;

import domain.Lotto;
import exception.InvalidInputException;
import view.InputView;

import static utils.Symbol.MANNUAL_INPUT_MESSAGE;

public class ManualGenerator implements LottoGenerator {
    private static final InputView inputview = new InputView();

    @Override
    public Lotto generate() throws InvalidInputException {
        Lotto lotto = inputview.getManualLotto(MANNUAL_INPUT_MESSAGE);
        return lotto;
    }
}
