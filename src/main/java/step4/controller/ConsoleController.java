package step4.controller;

import step4.command.LottoCommander;
import step4.input.CommandLineInputView;
import step4.input.InputResourceManager;
import step4.input.InputView;
import step4.lotto.domain.LottoTicket;
import step4.lotto.domain.WinningLotto;
import step4.output.CommandLineOutputView;
import step4.output.OutputView;

import java.util.List;

public class ConsoleController implements LottoGameController {
    private static InputView inputView = new CommandLineInputView();
    private static OutputView outputView = new CommandLineOutputView();

    @Override
    public void run() {
        //객체 만들기. inputview 넘겨주기. serverinputview도 생성해야함.
        LottoCommander lottoCommander = new LottoCommander(inputView, outputView);
        int amount = lottoCommander.inputPayAmount();

        List<LottoTicket> lottoTickets = lottoCommander.buyTickets(amount);
        lottoCommander.printTicketInfo(lottoTickets);

        WinningLotto winningLotto = lottoCommander.createWinningLotto();
        lottoCommander.checkAndShowResult(amount, lottoTickets, winningLotto);

        InputResourceManager.close();
    }
}
