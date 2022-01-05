package step4.lotto;

import step4.input.CommandLineInputView;
import step4.input.InputView;
import step4.lotto.domain.LottoTicket;

import java.util.List;

public class LottoCreatorSelf implements LottoCreater {

    private static InputView inputView = new CommandLineInputView();

    @Override
    public LottoTicket create() {
        return new LottoTicket(getNumbers());
    }

    private List<Integer> getNumbers() {
        return inputView.inputLottoNum();
    }
}
