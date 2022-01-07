package domain;

import valid.ConditionCheck;
import view.LottoServiceInputController;

import java.util.List;

import static view.Sentence.*;

public class ManualLottoGenerator implements LottoGenerator{

    private final LottoServiceInputController inputController;

    public ManualLottoGenerator(LottoServiceInputController inputController) {
        this.inputController = inputController;

    }

    @Override
    public LottoTicket getLottoTicket() {
        List<Integer> numbers = inputController.getManualLottoNumber();

        if(ConditionCheck.isValidLottoNumber(numbers)) {
            return new LottoTicket(numbers);
        }

        System.out.println(ERROR_INAPPROPRIATE_LOTTO_NUMBER.getString());
        return getLottoTicket();
    }
}
