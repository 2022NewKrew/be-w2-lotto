import domain.*;
import view.input.ConfigInputReader;
import view.input.LottoConfigBasicConsoleReader;
import view.input.ResultConsolReader;
import view.input.ResultInputReader;
import view.output.ConsoleOutputPrinter;
import view.output.OutputPrinter;

import java.util.Scanner;

public class LottoApplication {

    private final ConfigInputReader configInputReader;
    private final LottoSheetIssuer lottoSheetIssuer;
    private final ResultInputReader resultInputReader;
    private final OutputPrinter outputPrinter;


    public LottoApplication() {
        this.configInputReader = new LottoConfigBasicConsoleReader();
        this.lottoSheetIssuer = new BasicLottoSheetIssuer();
        this.resultInputReader = new ResultConsolReader();
        this.outputPrinter = new ConsoleOutputPrinter();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        LottoConfig lottoConfig = configInputReader.readConfig(sc);
        LottoSheet lottoSheet = lottoSheetIssuer.issueLottoSheet(lottoConfig);
        outputPrinter.printLottoSheet(lottoSheet);
        LottoResult lottoResult = resultInputReader.readResult(sc);
        outputPrinter.printLottoResult(lottoResult.getWinningResult(lottoSheet));
    }
}
