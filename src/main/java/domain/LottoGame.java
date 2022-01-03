package domain;

import dto.LottoData;
import view.input.ConsoleInputInterface;
import view.input.InputInterface;
import view.output.ConsoleOutputInterface;
import view.output.OutputInterface;

public class LottoGame {
    private final InputInterface inputInterface = new ConsoleInputInterface();
    private final OutputInterface outputInterface = new ConsoleOutputInterface();

    private final LottoData lottoData = new LottoData();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void start() throws Exception {
        inputInterface.openScanner();

        lottoData.setBudget(inputInterface.inputBudget());

        Lotto lotto = lottoGenerator.generate(lottoData);
        outputInterface.printTickets(lotto);

        lottoData.setWinningNumbers(inputInterface.inputWinningNumbers());
        lotto.calculateResult(lottoData.getWinningNumbers());
        outputInterface.printResults(lotto);

        lottoData.setRevenue(lotto.getProfit());
        outputInterface.printRevenueRate(lottoData);

        inputInterface.closeScanner();
    }
}
