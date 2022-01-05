import java.util.List;

import View.LottoInputView;
import View.LottoOutputView;
import controller.LottoController;
import domain.Lotto;
import domain.WinningLotto;
import dto.request.LottoPurchaseInfo;
import dto.response.LottoPurchaseAmount;
import dto.response.LottoStatistics;
import service.LottoService;

public class Main {
	public static void main(String[] args) {
		LottoService lottoService = new LottoService();
		LottoController lottoController = new LottoController(lottoService);

		LottoPurchaseInfo lottoPurchaseInfo = LottoInputView.getPurchaseMoney();
		LottoPurchaseAmount lottoPurchaseAmount = lottoController.getPurchaseAmount(lottoPurchaseInfo);

		List<Lotto> lottoList = LottoInputView.getCustomLotto(lottoPurchaseAmount);
		List<Lotto> autoLottoList = lottoController.purchase(lottoPurchaseAmount.getAutoAmount());

		lottoList.addAll(autoLottoList);
		LottoOutputView.printPurchaseAmount(lottoPurchaseAmount);
		LottoOutputView.printLotto(lottoList);

		WinningLotto winningLotto = LottoInputView.getWinningLotto();
		LottoStatistics lottoStatistics = lottoController.getStatistics(lottoList, winningLotto);
		LottoOutputView.printLottoStatistics(lottoStatistics);
	}
}
