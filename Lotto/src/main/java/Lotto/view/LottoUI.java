package Lotto.view;

import Lotto.domain.LottoManager;
import Lotto.domain.LottoStatistics;

import java.util.ArrayList;
import java.util.List;

public class LottoUI {
    public static void start(){
        LottoManager lottoManager = new LottoManager();
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();

        lottoManager.buyTickets(inputManager.inputPrice(), inputManager.inputManualTicket());     // 구입금액 입력 and 수동으로 구매할 번호 입력 and 로또 복권 구입
        outputManager.printTickets(lottoManager.getManualTickets(), lottoManager.getRandomTickets()); // 로또 출력

        // 지난 주 당첨 번호 입력
        lottoManager.setWiningNumber(inputManager.inputWiningNumber());
        // 보너스 숫자 입력
        lottoManager.setBonusNumber(inputManager.inputBonusNumber(lottoManager.getWiningNumber()));
        // 로또 통계 생성
        LottoStatistics lottoStatistics = new LottoStatistics(lottoManager.getInvestmentAmount(), lottoManager.getManualTickets(),
                lottoManager.getRandomTickets(), lottoManager.getWiningNumber(), lottoManager.getBonusNumber());
        // 로또 통계 출력
        outputManager.printStatistics(lottoStatistics.getCountOfWining(), lottoStatistics.getRateOfProfit());
    }
}
