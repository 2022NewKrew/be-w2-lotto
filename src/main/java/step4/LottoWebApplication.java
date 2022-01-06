package step4;

import step2.controller.LottoController;
import step2.domain.service.LottoResultGenerator;
import step2.domain.service.LottoResultGeneratorImpl;
import step2.domain.service.LottoSheetIssuer;
import step2.repository.LottoSheetMemoryRepository;
import step2.repository.LottoSheetRepository;
import step3.domain.AutoAndManualLottoSheetIssuer;
import step4.controller.LottoWebController;

import static spark.Spark.*;

public class LottoWebApplication {
    private final LottoWebController lottoController;
    private final LottoSheetRepository lottoSheetRepository;
    private final LottoSheetIssuer lottoSheetIssuer;
    private final LottoResultGenerator lottoResultGenerator;

    public LottoWebApplication() {
        // LottoSheet(로또 번호 모음) 저장
        this.lottoSheetRepository = new LottoSheetMemoryRepository();
        // LottoSheet 생성 담당
        this.lottoSheetIssuer = new AutoAndManualLottoSheetIssuer(lottoSheetRepository);
        // LottoSheet과 WinningLotto(당첨 번호)로 결과 생성
        this.lottoResultGenerator = new LottoResultGeneratorImpl();
        // 뷰 로직과 도메인 로직을 연결하는 Controller
        this.lottoController = new LottoWebController(lottoSheetIssuer, lottoSheetRepository, lottoResultGenerator);
    }

    public void start(){
        staticFiles.location("/templates");
        port(8080);

        post("buyLotto", (req, res) -> lottoController.purchase(req, res));
        post("matchLotto", (req, res) -> lottoController.checkLotteryResult(req, res));
    }
}
