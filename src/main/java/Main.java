import java.util.List;

import View.LottoInputView;
import View.LottoOutputView;
import controller.LottoController;
import domain.Lotto;
import domain.LottoStatistics;
import domain.WinningLotto;
import service.LottoService;

public class Main {
	public static void main(String[] args) {
		LottoService lottoService = new LottoService();
		LottoController lottoController = new LottoController(lottoService);

		int purchaseMoney = LottoInputView.getPurchaseMoney();
		int purchaseAmount = lottoController.getPurchaseAmount(purchaseMoney);
		LottoOutputView.printPurchaseAmount(purchaseAmount);

		List<Lotto> lottoList = lottoController.purchase(purchaseAmount);
		LottoOutputView.printLotto(lottoList);

		WinningLotto winningLotto = LottoInputView.getWinningLotto();
		LottoStatistics lottoStatistics = lottoController.getStatistics(lottoList, winningLotto);
		LottoOutputView.printLottoStatistics(lottoStatistics);
	}
}
