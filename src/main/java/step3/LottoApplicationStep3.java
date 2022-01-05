package step3;

import step2.controller.LottoController;
import step2.controller.LottoControllerImpl;
import step2.domain.service.LottoResultGenerator;
import step2.domain.service.LottoResultGeneratorImpl;
import step2.domain.service.LottoSheetIssuer;
import step2.repository.LottoSheetMemoryRepository;
import step2.repository.LottoSheetRepository;
import step2.view.ConfigView;
import step2.view.ConsoleResultView;
import step2.view.ResultView;
import step3.domain.AutoAndManualLottoSheetIssuer;
import step3.view.ConsoleConfigWithManualView;

import java.util.Scanner;

public class LottoApplicationStep3 {
    private final LottoController lottoController;
    private final ConfigView configView;
    private final LottoSheetRepository lottoSheetRepository;
    private final LottoSheetIssuer lottoSheetIssuer;
    private final ResultView resultView;
    private final LottoResultGenerator lottoResultGenerator;

    public LottoApplicationStep3() {
        // LottoSheet(로또 번호 모음) 저장
        this.lottoSheetRepository = new LottoSheetMemoryRepository();
        // LottoSheet 생성 담당
        this.lottoSheetIssuer = new AutoAndManualLottoSheetIssuer(lottoSheetRepository);
        // LottoSheet과 WinningLotto(당첨 번호)로 결과 생성
        this.lottoResultGenerator = new LottoResultGeneratorImpl();
        // 뷰 로직과 도메인 로직을 연결하는 Controller
        this.lottoController = new LottoControllerImpl(lottoSheetIssuer, lottoSheetRepository, lottoResultGenerator);
        // 구매 정보 입출력
        this.configView = new ConsoleConfigWithManualView(lottoController);
        // 당첨 번호 입력 및 결과 출력
        this.resultView = new ConsoleResultView(lottoController);
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        configView.print(sc);
        resultView.print(sc);
        sc.close();
    }
}
