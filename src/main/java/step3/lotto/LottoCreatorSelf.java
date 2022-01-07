package step3.lotto;

import step3.input.CommandLineInputView;
import step3.input.InputView;
import step3.lotto.domain.LottoTicket;

import java.util.List;

public class LottoCreatorSelf implements LottoCreater{

    private static InputView inputView = new CommandLineInputView();

    @Override
    public LottoTicket create() {
        return new LottoTicket(getNumbers());
    }

    private List<Integer> getNumbers() {
        return inputView.inputLottoNum();
    }
}
