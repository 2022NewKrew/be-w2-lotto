package step2;

import step2.domain.service.LottoResultGenerator;
import step2.domain.service.LottoResultGeneratorImpl;
import step2.domain.service.LottoSheetIssuer;
import step2.controller.LottoController;
import step2.controller.LottoControllerImpl;
import step2.domain.service.LottoSheetIssuerWithRepo;
import step2.repository.LottoSheetMemoryRepository;
import step2.repository.LottoSheetRepository;
import step2.view.ConfigView;
import step2.view.ConsoleConfigView;
import step2.view.ConsoleResultView;
import step2.view.ResultView;

import java.util.Scanner;

public class LottoApplicationStep2 {
    private final LottoController lottoController;
    private final ConfigView configView;
    private final LottoSheetRepository lottoSheetRepository;
    private final LottoSheetIssuer lottoSheetIssuer;
    private final ResultView resultView;
    private final LottoResultGenerator lottoResultGenerator;

    public LottoApplicationStep2() {
        this.lottoSheetRepository = new LottoSheetMemoryRepository();
        this.lottoSheetIssuer = new LottoSheetIssuerWithRepo(lottoSheetRepository);
        this.lottoResultGenerator = new LottoResultGeneratorImpl();
        this.lottoController = new LottoControllerImpl(lottoSheetIssuer, lottoSheetRepository, lottoResultGenerator);
        this.configView = new ConsoleConfigView(lottoController);
        this.resultView = new ConsoleResultView(lottoController);
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        configView.print(sc);
        resultView.print(sc);
    }
}
