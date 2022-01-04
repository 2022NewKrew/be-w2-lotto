package lotto;

import input.CommandLineInputView;
import input.InputView;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
